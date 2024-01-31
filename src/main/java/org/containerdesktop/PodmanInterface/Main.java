package org.containerdesktop.PodmanInterface;

import org.containerdesktop.PodmanInterface.Builder.DefaultNetworkConfigBuilder;
import org.containerdesktop.PodmanInterface.Builder.NetworkConfigBuilder;
import org.containerdesktop.PodmanInterface.Entity.Network;

public class Main {
    public static void main(String[] args) throws Exception {
//        SocketAddress addr = AFUNIXSocketAddress.of(new File("/run/podman/podman.sock"));
//        String apiUrl = "http://localhost/v4.0.0/libpod/networks/json";
//        OkHttpClient client = new OkHttpClient.Builder()
//                .socketFactory(new AFSocketFactory.FixedAddressSocketFactory(addr))
//                .callTimeout(Duration.ofMinutes(1))
//                .build();
//        Request request = new Request.Builder()
//                .get()
//                .url(apiUrl)
//                .build();
//        Response response = client.newCall(request).execute();
//        assert response.body() != null;
//        String string = response.body().string();
//        List<Network> networks = JSONArray.parseArray(string).stream()
//                .map(JSONObject.class::cast)
//                .map(Network::parse)
//                .collect(Collectors.toList());
//
//        System.out.println(networks);

        PodmanClient client = new PodmanClient.Builder()
                .socket("/run/podman/podman.sock")
                .version("4.0.0")
                .compat(true)
                .build();
//        System.out.println(client.network().create(new DefaultNetworkConfigBuilder()
//                .name("test")
//                .driver(Network.Driver.BRIDGE)
//                .build()));
//        System.out.println(client.network().get("test"));
        client.network().delete("test");

    }

}
