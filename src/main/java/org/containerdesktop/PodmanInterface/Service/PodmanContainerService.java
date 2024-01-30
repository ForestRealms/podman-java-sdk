package org.containerdesktop.PodmanInterface.Service;

import okhttp3.OkHttpClient;
import org.containerdesktop.PodmanInterface.Configuration.Config;
import org.containerdesktop.PodmanInterface.Entity.Container;

import java.io.IOException;
import java.util.List;

public class PodmanContainerService implements ContainerService {

    private OkHttpClient okHttpClient;

    public PodmanContainerService(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }


    @Override
    public void create(Config<Container> config) throws IOException {

    }

    @Override
    public void delete(String name) {

    }

    @Override
    public List<Container> list()  {
        return null;
    }
}
