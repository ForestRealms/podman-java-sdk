package org.containerdesktop.PodmanInterface.Service;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.containerdesktop.PodmanInterface.Configuration.Config;
import org.containerdesktop.PodmanInterface.Entity.Network;

import java.io.IOException;
import java.lang.reflect.Array;
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
                .url(baseURL + "/libpod/networks/json")
                .build();
        try (Response response = this.okHttpClient.newCall(request).execute()) {
            assert response.body() != null;
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
    public void create(Config<Network> config) {
        Network network = config.getInstance();
        // 执行命令创建网络
//        Request request = new Request.Builder()
//                .post(new FormBody.Builder()
//                        .add("name", network.getName())
//                        .add()
//                        .build())
//                .header("Content-Type", "application/json")
//                .url(baseURL + "/libpod/networks/create")
//                .build();
//        try (Response response = okHttpClient.newCall(request).execute()) {
//            assert response.body() != null;
//            System.out.println(response.body().string());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        String[] env = {"PATH=/usr/bin:/bin:/usr/local/bin"};
        try {
            Runtime.getRuntime().exec(new String[]{"podman", "network", "create", network.getName()});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void delete(String name) {

    }
}
