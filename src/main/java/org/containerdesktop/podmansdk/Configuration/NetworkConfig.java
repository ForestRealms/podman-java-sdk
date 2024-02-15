package org.containerdesktop.podmansdk.Configuration;

import org.containerdesktop.podmansdk.Entity.Network;

public interface NetworkConfig extends Config<Network> {

    String getName();

    void setName(String name);

    Network.Driver getDriver();

    void setDriver(Network.Driver driver);

    String getNetworkInterface();

    void setNetworkInterface(String networkInterface);

    boolean isIPv6Enabled();

    void setIPv6Enabled(boolean IPv6Enabled);

    boolean isInternal();

    void setInternal(boolean internal);

    boolean isDNSEnabled();

    void setDNSEnabled(boolean DNSEnabled);

    void addSubnet(Network.Subnet subnet);

    void addSubnet(String subnetAddr, String gatewayAddr);

    void putIPAMOptions(String key, String value);
}
