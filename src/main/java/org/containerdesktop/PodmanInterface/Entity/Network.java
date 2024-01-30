package org.containerdesktop.PodmanInterface.Entity;

import com.alibaba.fastjson2.JSONObject;
import org.containerdesktop.PodmanInterface.Exception.InvalidNetworkDriverException;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface Network {
    String getName();
    String getId();
    Driver getDriver();
    String getNetworkInterface();
    Date getCreated();
    List<Subnet> getSubnets();
    boolean isIPv6Enabled();
    boolean isInternal();
    boolean isDNSEnabled();
    Map<String, String> getIPAMOptions();


    interface Subnet {
        String getSubnetCIDRAddr();
        String getGatewayAddr();
    }

    enum Driver {
        BRIDGE,
        MACVLAN,
        IPVLAN;

        static Driver fromString(String s){
            return switch (s) {
                case "bridge" -> BRIDGE;
                case "macvlan" -> MACVLAN;
                case "ipvlan" -> IPVLAN;
                default -> throw new InvalidNetworkDriverException("invalidNetworkDriver", s);
            };
        }
    }


    static Network parse(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String id = jsonObject.getString("id");
        Driver driver = Driver.fromString(jsonObject.getString("driver"));
        String networkInterface = jsonObject.getString("network_interface");
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(jsonObject.getString("created"), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        Date createdDate = Date.from(offsetDateTime.toInstant());
        List<Subnet> subnets = new ArrayList<>();
        for (JSONObject m : jsonObject.getJSONArray("subnets").toList(JSONObject.class)) {
            subnets.add(new Subnet() {
                @Override
                public String getSubnetCIDRAddr() {
                    return m.getString("subnet");
                }

                @Override
                public String getGatewayAddr() {
                    return m.getString("gateway");
                }
            });
        }
        boolean IPv6Enabled = jsonObject.getBoolean("ipv6_enabled"),
                internal = jsonObject.getBoolean("internal"),
                DNSEnabled = jsonObject.getBoolean("dns_enabled");

        JSONObject ipamOptions = jsonObject.getJSONObject("ipam_options");

        Map<String, String> IPAMOptions = ipamOptions
                .keySet().stream().collect(Collectors.toMap(
                        key -> key,
                        ipamOptions::getString
                ));

        return new PodmanNetwork(name, id, driver, networkInterface, createdDate, subnets, IPv6Enabled, internal
        , DNSEnabled, IPAMOptions);
    }
}
