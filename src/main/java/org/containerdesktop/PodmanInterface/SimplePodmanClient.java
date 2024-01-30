package org.containerdesktop.PodmanInterface;

import okhttp3.OkHttpClient;
import org.containerdesktop.PodmanInterface.Service.ContainerService;
import org.containerdesktop.PodmanInterface.Service.NetworkService;
import org.containerdesktop.PodmanInterface.Service.PodmanNetworkService;
import org.newsclub.net.unix.AFSocketFactory;
import org.newsclub.net.unix.AFUNIXSocketAddress;

import java.io.File;
import java.net.SocketException;
import java.time.Duration;

public class SimplePodmanClient implements PodmanClient{

    private String socket;
    private OkHttpClient client;
    private String baseURL;

    public SimplePodmanClient(String socket, String baseURL) throws SocketException {
        this.socket = socket;
        this.client = new OkHttpClient.Builder()
                .socketFactory(new AFSocketFactory.FixedAddressSocketFactory(AFUNIXSocketAddress.of(new File(this.socket))))
                .callTimeout(Duration.ofMinutes(1))
                .build();
        this.baseURL = baseURL;
    }

    @Override
    public NetworkService network() {
        return new PodmanNetworkService(this.client, this.baseURL);
    }

    @Override
    public ContainerService container() {
        return null;
    }
}
