package org.containerdesktop.podmansdk.Service;

import com.alibaba.fastjson2.JSONObject;
import okhttp3.*;
import org.containerdesktop.podmansdk.Configuration.Config;
import org.containerdesktop.podmansdk.Entity.Container;

import java.io.IOException;
import java.util.List;

public class PodmanContainerService implements ContainerService {

    private OkHttpClient okHttpClient;
    private String baseURL;


    public PodmanContainerService(OkHttpClient okHttpClient, String baseURL) {
        this.okHttpClient = okHttpClient;
        this.baseURL = baseURL;
    }


    @Override
    public String create(Config<Container> config) {
        Container container = config.getInstance();
        String imageName = container.getImageName();
        JSONObject r = new JSONObject();
        r.put("image", imageName);
        RequestBody requestBody = RequestBody.create(r.toJSONString(), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url(baseURL + "/containers/create")
                .post(requestBody)
                .build();

        try (Response response = this.okHttpClient.newCall(request).execute()) {
            int code = response.code();
            String s = response.body().string();
            System.out.println(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void delete(String name) {

    }

    @Override
    public List<Container> list()  {
        return null;
    }

    @Override
    public Container get(String name) {
        return null;
    }
}
