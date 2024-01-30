package org.containerdesktop.PodmanInterface.Builder;

import org.containerdesktop.PodmanInterface.Configuration.NetworkConfig;
import org.containerdesktop.PodmanInterface.Configuration.PodmanNetworkConfig;
import org.containerdesktop.PodmanInterface.Entity.Network;

import java.net.SocketException;

public class DefaultNetworkConfigBuilder implements NetworkConfigBuilder{
    private final NetworkConfig config = new PodmanNetworkConfig() {{
        setDriver(Network.Driver.BRIDGE);
    }};



    @Override
    public NetworkConfigBuilder name(String name){
        this.config.setName(name);
        return this;
    }

    @Override
    public NetworkConfigBuilder driver(Network.Driver driver){
        this.config.setDriver(driver);
        return this;
    }

    @Override
    public NetworkConfigBuilder networkInterface(String networkInterface) {
        this.config.setNetworkInterface(networkInterface);
        return this;
    }

    @Override
    public NetworkConfigBuilder addSubnet(Network.Subnet subnet) {
        this.config.addSubnet(subnet);
        return this;
    }

    @Override
    public NetworkConfigBuilder addSubnet(String subnetAddr, String gatewayAddr) {
        this.config.addSubnet(new Network.Subnet() {
            @Override
            public String getSubnetCIDRAddr() {
                return subnetAddr;
            }

            @Override
            public String getGatewayAddr() {
                return gatewayAddr;
            }
        });
        return this;
    }

    @Override
    public NetworkConfigBuilder setIPv6Enabled(boolean enabled) {
        this.config.setIPv6Enabled(enabled);
        return this;
    }

    @Override
    public NetworkConfigBuilder setInternal(boolean enabled) {
        this.config.setInternal(enabled);
        return this;
    }

    @Override
    public NetworkConfigBuilder setDNSEnabled(boolean enabled) {
        this.config.setDNSEnabled(enabled);
        return this;
    }

    @Override
    public NetworkConfigBuilder addIPAMOptions(String key, String value) {
        this.config.putIPAMOptions(key, value);
        return this;
    }

    @Override
    public NetworkConfig build() throws SocketException {
        return this.config;
    }
}
