package org.containerdesktop.PodmanInterface.Service;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import okhttp3.*;
import org.containerdesktop.PodmanInterface.Configuration.Config;
import org.containerdesktop.PodmanInterface.Entity.Volume;
import org.containerdesktop.PodmanInterface.Exception.InteractiveException;
import org.containerdesktop.PodmanInterface.Exception.InternalServerError;
import org.containerdesktop.PodmanInterface.Exception.NoSuchVolumeException;
import org.containerdesktop.PodmanInterface.Exception.VolumeIsInUseException;

import java.io.IOException;
import java.util.List;

public class PodmanVolumeService implements VolumeService {

    private final OkHttpClient okHttpClient;
    private final String baseURL;
    private final boolean compat;

    public PodmanVolumeService(OkHttpClient okHttpClient, String baseURL, boolean compat) {
        this.okHttpClient = okHttpClient;
        this.baseURL = baseURL;
        this.compat = compat;
    }

    @Override
    public String create(Config<Volume> config) {
        JSONObject r = new JSONObject();
        r.put("Name", config.getInstance().getName());
        r.put("Driver", config.getInstance().getDriver().toString());
        r.put("Options", new JSONObject(config.getInstance().getOptions()));
        r.put("Labels", new JSONObject(config.getInstance().getLabels()));

        RequestBody requestBody = RequestBody.create(r.toJSONString(), MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .post(requestBody)
                .url(baseURL + "/volumes/create")
                .build();

        try (Response response = this.okHttpClient.newCall(request).execute()) {
            int code = response.code();
            ResponseBody responseBody = response.body();
            String s = responseBody.string();
            switch (code) {
                case 201:
                    System.out.println(s);
                    return JSONObject.parseObject(s).getString("Id");
                case 500:
                    throw new InternalServerError("internalServerError", InteractiveException.getErrorMessageFromResponse(s));
                default:
                    break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @Override
    public void delete(String name) {
        Request request = new Request.Builder()
                .delete()
                .url(baseURL + "/volumes/" + name)
                .build();

        try (Response response = this.okHttpClient.newCall(request).execute()){
            ResponseBody responseBody = response.body();
            int code = response.code();
            String s = responseBody.string();
            switch (code) {
                case 204:
                    break;
                case 404:
                    throw new NoSuchVolumeException("noSuchVolumeException", InteractiveException.getErrorMessageFromResponse(s), name, null);
                case 409:
                    throw new VolumeIsInUseException("volumeIsInUse", InteractiveException.getErrorMessageFromResponse(s), name, null);
                case 500:
                    throw new InternalServerError("internalServerError", InteractiveException.getErrorMessageFromResponse(s));
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Volume> list() {
        Request request;
        List<Volume> volumes = null;
        if (!compat) {
            request = new Request.Builder()
                    .get()
                    .url(baseURL + "/volumes/json")
                    .build();
        }else {
            request = new Request.Builder()
                    .get()
                    .url(baseURL + "/volumes")
                    .build();
        }
        try (Response response = this.okHttpClient.newCall(request).execute()) {
            int code = response.code();
            ResponseBody responseBody = response.body();
            String s = responseBody.string();
            // 判断是否使用兼容模式
            JSONArray volumeJSONArray = compat ? JSONObject.parseObject(s).getJSONArray("Volumes") : JSONArray.parseArray(s);
            volumes = switch (code) {
                case 200 -> volumeJSONArray.stream()
                        .map(JSONObject.class::cast)
                        .map(Volume::parse).toList();
                case 500 ->
                        throw new InternalServerError("internalServerError", InteractiveException.getErrorMessageFromResponse(s));
                default -> volumes;
            };
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return volumes;
    }

    @Override
    public Volume get(String name) {
        Request request;
        if (compat) {
            request = new Request.Builder()
                    .get()
                    .url(baseURL + "/volumes/" + name)
                    .build();
        }else {
            request = new Request.Builder()
                    .get()
                    .url(baseURL + "/volumes/" + name + "/json")
                    .build();
        }
        try (Response response = this.okHttpClient.newCall(request).execute()) {
            ResponseBody responseBody = response.body();
            int code = response.code();
            String s = responseBody.string();
            switch (code) {
                case 200:
                    return JSONObject.parseObject(s).to(Volume::parse);
                case 404:
                    throw new NoSuchVolumeException("noSuchVolumeException", InteractiveException.getErrorMessageFromResponse(s), name, null);
                case 500:
                    throw new InternalServerError("internalServerError", InteractiveException.getErrorMessageFromResponse(s));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean exists(String name) {

        if (compat) {
            for (Volume volume : this.list()) {
                if(volume.getName().equals(name)) return true;
            }
            return false;
        }else {
            Request request = new Request.Builder()
                    .get()
                    .url(baseURL + "/volume/" + name + "/exists")
                    .build();
            try (Response response = this.okHttpClient.newCall(request).execute()) {
                String s = response.body().string();
                switch (response.code()) {
                    case 204:
                        return true;
                    case 404:
                        return false;
                    case 500:
                        throw new InternalServerError("internalServerError", InteractiveException.getErrorMessageFromResponse(s));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;

    }
}
