package org.containerdesktop.podmansdk.Service;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import okhttp3.*;
import org.containerdesktop.podmansdk.Configuration.Config;
import org.containerdesktop.podmansdk.Entity.Image;
import org.containerdesktop.podmansdk.Exception.InteractiveException;
import org.containerdesktop.podmansdk.Exception.InternalServerError;
import org.containerdesktop.podmansdk.Exception.NoSuchImageException;

import java.io.IOException;
import java.util.List;

public class PodmanImageService implements ImageService {

    private final OkHttpClient okHttpClient;
    private final String baseURL;

    public PodmanImageService(OkHttpClient okHttpClient, String baseURL) {
        this.okHttpClient = okHttpClient;
        this.baseURL = baseURL;
    }

    @Override
    public String create(Config<Image> config) throws IOException {
        return null;
    }

    @Override
    public void delete(String name) {

    }

    @Override
    public List<Image> list() {
        Request request = new Request.Builder()
                .get()
                .url(baseURL + "/images/json")
                .build();
        ResponseBody responseBody;
        List<Image> images;
        try (Response response = okHttpClient.newCall(request).execute()) {
            responseBody = response.body();
            int code = response.code();
            String s = responseBody.string();
            if (code == 500){
                throw new InternalServerError("internalServerError", InteractiveException.getErrorMessageFromResponse(s));
            }
            images = JSONArray.parseArray(s).stream()
                    .map(JSONObject.class::cast)
                    .map(Image::parse)
                    .toList();
            return images;


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Image get(String name) {
        return null;
    }

    @Override
    public void pull(String fromImage, String tag) {
        RequestBody requestBody = RequestBody.create(new JSONObject().toJSONString(), null);
        Request request = new Request.Builder()
                .post(requestBody)
                .url(baseURL + "/images/create?fromImage="+fromImage+"&tag="+tag)
                .build();

        ResponseBody responseBody;
        try (Response response = this.okHttpClient.newCall(request).execute()) {
           responseBody = response.body();
            int code = response.code();
            String s = responseBody.string();
            System.out.println(s);
            switch (code) {
                case 200:
                    break;
                case 404:
                    throw new NoSuchImageException("noSuchImageException", InteractiveException.getErrorMessageFromResponse(s), null, fromImage);
                case 500:
                    throw new InternalServerError("internalServerError", InteractiveException.getErrorMessageFromResponse(s));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
