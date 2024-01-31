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


    String create(Config<T> config) throws IOException;
    void delete(String name);
    List<T> list();
    T get(String name);
}
