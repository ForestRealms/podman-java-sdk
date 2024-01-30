package org.containerdesktop.PodmanInterface.Service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.containerdesktop.PodmanInterface.Configuration.Config;
import org.newsclub.net.unix.AFSocketFactory;
import org.newsclub.net.unix.AFUNIXSocketAddress;

import java.io.File;
import java.io.IOException;
import java.net.SocketAddress;
import java.time.Duration;
import java.util.List;

public interface Service<T> {

    default Response get(String socket, String path) throws IOException {
        SocketAddress socketAddress = AFUNIXSocketAddress.of(new File(socket));
        OkHttpClient client = new OkHttpClient.Builder()
                .socketFactory(new AFSocketFactory.FixedAddressSocketFactory(socketAddress))
                .callTimeout(Duration.ofMinutes(1))
                .build();
        Request request = new Request.Builder()
                .get()
                .url(path)
                .build();
        return client.newCall(request).execute();
    }

    void create(Config<T> config) throws IOException;
    void delete(String name);
    List<T> list();
    T get(String name);
}
