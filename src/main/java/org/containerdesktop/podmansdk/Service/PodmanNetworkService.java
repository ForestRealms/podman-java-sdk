package org.containerdesktop.podmansdk.Service;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import okhttp3.*;
import org.containerdesktop.podmansdk.Configuration.Config;
import org.containerdesktop.podmansdk.Entity.Network;
import org.containerdesktop.podmansdk.Exception.InteractiveException;
import org.containerdesktop.podmansdk.Exception.InternalServerError;
import org.containerdesktop.podmansdk.Exception.NetworkAlreadyExists;
import org.containerdesktop.podmansdk.Exception.NoSuchNetworkException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PodmanNetworkService implements NetworkService{

    private OkHttpClient okHttpClient;
    private String baseURL;

    public PodmanNetworkService(OkHttpClient okHttpClient, String baseURL) {
        this.okHttpClient = okHttpClient;
        this.baseURL = baseURL;
    }


    @Override
    public List<Network> list() {
        List<Network> networks;
        Request request = new Request.Builder()
                .get()
                .url(baseURL + "/networks/json")
                .build();
        try (Response response = this.okHttpClient.newCall(request).execute()) {
             networks = JSONArray.parseArray(response.body().string()).stream()
                    .map(JSONObject.class::cast)
                    .map(Network::parse)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return networks;
    }

    @Override
    public Network get(String name) {
        Request request = new Request.Builder()
                .get()
                .url(baseURL + "/networks/" + name)
                .build();
        ResponseBody responseBody;
        try (Response response = okHttpClient.newCall(request).execute()) {
            responseBody = response.body();
            int code = response.code();
            String s = responseBody.string();
            switch (code) {
                case 200:
                    break;
                case 404:
                    throw new NoSuchNetworkException("noSuchNetwork",
                            InteractiveException.getErrorMessageFromResponse(s),
                            name);
                case 500:
                    throw new InternalServerError("internalServerError", InteractiveException.getErrorMessageFromResponse(s));
            }
            return JSONObject.parse(s).to(Network::parse);



        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String create(Config<Network> config) {
        Network network = config.getInstance();
        List<JSONObject> subnet0 = new ArrayList<>();
        for (Network.Subnet subnet : network.getSubnets()) {
            subnet0.add(JSONObject.of("subnet", subnet.getSubnetCIDRAddr(), "gateway", subnet.getGatewayAddr()));
        }
        JSONObject r = new JSONObject();
        JSONObject data = new JSONObject(network.getIPAMOptions());
        r.put("name", network.getName());
        r.put("driver", network.getDriver().toString());
        r.put("dns_enabled", network.isDNSEnabled());
        r.put("subnets", subnet0);
        r.put("enable_ipv6", network.isIPv6Enabled());
        r.put("internal", network.isInternal());
        r.put("data", data);

        Request request = new Request.Builder()
                .post(RequestBody.create(r.toJSONString(), MediaType.parse("application/json")))
                .url(baseURL + "/networks/create")
                .build();

        ResponseBody responseBody;
        try (Response response = okHttpClient.newCall(request).execute()) {
            responseBody = response.body();
            String s = responseBody.string();
            if (response.code() == 500) {
                switch (InteractiveException.getCauseMessageFromResponse(s)) {
                                case "network already exists":
                                    throw new NetworkAlreadyExists("networkAlreadyExists",
                                            InteractiveException.getErrorMessageFromResponse(s), network.getName());
                                case null, default:
                                    throw new InternalServerError("internalServerError", InteractiveException.getErrorMessageFromResponse(s));
                            }
            }

            return JSONObject.parseObject(s).getString("Id");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void delete(String name) {
        Request request = new Request.Builder()
                .delete()
                .url(baseURL + "/networks/" + name)
                .build();

        ResponseBody responseBody;
        try (Response response = okHttpClient.newCall(request).execute()) {
            responseBody = response.body();
            int code = response.code();
            String s = responseBody.string();
            switch (code) {
                case 404:
                    throw new NoSuchNetworkException("noSuchNetwork", InteractiveException.getErrorMessageFromResponse(s), name);
                case 500:
                    throw new InternalServerError("internalServerError", InteractiveException.getErrorMessageFromResponse(s));
                default:
                    break;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
