package org.containerdesktop.PodmanInterface.Builder;

import org.containerdesktop.PodmanInterface.Configuration.NetworkConfig;
import org.containerdesktop.PodmanInterface.Entity.Network;

public interface NetworkConfigBuilder extends Builder<NetworkConfig> {
    NetworkConfigBuilder name(String name);

    NetworkConfigBuilder driver(Network.Driver driver);

    NetworkConfigBuilder networkInterface(String networkInterface);

    NetworkConfigBuilder addSubnet(Network.Subnet subnet);

    NetworkConfigBuilder addSubnet(String subnetAddr, String gatewayAddr);

    NetworkConfigBuilder setIPv6Enabled(boolean enabled);

    NetworkConfigBuilder setInternal(boolean enabled);

    NetworkConfigBuilder setDNSEnabled(boolean enabled);

    NetworkConfigBuilder addIPAMOptions(String key, String value);
}
