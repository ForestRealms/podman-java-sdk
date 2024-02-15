package org.containerdesktop.podmansdk.Service;

import okhttp3.OkHttpClient;
import org.containerdesktop.podmansdk.Configuration.Config;
import org.containerdesktop.podmansdk.Entity.Container;

import java.util.List;

public class PodmanContainerService implements ContainerService {

    private OkHttpClient okHttpClient;

    public PodmanContainerService(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }


    @Override
    public String create(Config<Container> config) {
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
