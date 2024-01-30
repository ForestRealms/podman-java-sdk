package org.containerdesktop.PodmanInterface.Configuration;

import org.containerdesktop.PodmanInterface.Entity.Network;
import org.containerdesktop.PodmanInterface.Entity.PodmanNetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PodmanNetworkConfig implements NetworkConfig{

    private String name;
    private Network.Driver driver;
    private String networkInterface;
    private final List<Network.Subnet> subnets = new ArrayList<>();
    private boolean IPv6Enabled = false;
    private boolean internal = false;
    private boolean DNSEnabled= false;
    private final Map<String, String> IPAMOptions = new HashMap<>(Map.of("driver", "host-local"));

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Network.Driver getDriver() {
        return driver;
    }

    @Override
    public void setDriver(Network.Driver driver) {
        this.driver = driver;
    }

    @Override
    public String getNetworkInterface() {
        return networkInterface;
    }

    @Override
    public void setNetworkInterface(String networkInterface) {
        this.networkInterface = networkInterface;
    }

    @Override
    public boolean isIPv6Enabled() {
        return IPv6Enabled;
    }

    @Override
    public void setIPv6Enabled(boolean IPv6Enabled) {
        this.IPv6Enabled = IPv6Enabled;
    }

    @Override
    public boolean isInternal() {
        return internal;
    }

    @Override
    public void setInternal(boolean internal) {
        this.internal = internal;
    }

    @Override
    public boolean isDNSEnabled() {
        return DNSEnabled;
    }

    @Override
    public void setDNSEnabled(boolean DNSEnabled) {
        this.DNSEnabled = DNSEnabled;
    }

    @Override
    public void addSubnet(Network.Subnet subnet) {
        this.subnets.add(subnet);
    }

    @Override
    public void addSubnet(String subnetAddr, String gatewayAddr) {
        this.subnets.add(new Network.Subnet() {
            @Override
            public String getSubnetCIDRAddr() {
                return subnetAddr;
            }

            @Override
            public String getGatewayAddr() {
                return gatewayAddr;
            }
        });
    }

    @Override
    public void putIPAMOptions(String key, String value) {
        this.IPAMOptions.put(key, value);
    }

    @Override
    public Network getInstance() {
        return new PodmanNetwork(name, null, driver, networkInterface, null, subnets, IPv6Enabled,
                internal, DNSEnabled, IPAMOptions);
    }
}
