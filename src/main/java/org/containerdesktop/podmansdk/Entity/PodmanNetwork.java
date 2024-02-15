package org.containerdesktop.podmansdk.Entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

public record PodmanNetwork(String name,
                            String id,
                            Network.Driver driver,
                            String networkInterface,
                            Date createdDate,
                            List<Network.Subnet> subnets,
                            boolean IPv6Enabled,
                            boolean internal,
                            boolean DNSEnabled,
                            Map<String, String> IPAMOptions) implements Network{


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Driver getDriver() {
        return this.driver;
    }

    @Override
    public String getNetworkInterface() {
        return this.networkInterface;
    }

    @Override
    public Date getCreated() {
        return this.createdDate;
    }

    @Override
    public List<Subnet> getSubnets() {
        return this.subnets;
    }

    @Override
    public boolean isIPv6Enabled() {
        return this.IPv6Enabled;
    }

    @Override
    public boolean isInternal() {
        return this.internal;
    }

    @Override
    public boolean isDNSEnabled() {
        return this.DNSEnabled;
    }

    @Override
    public Map<String, String> getIPAMOptions() {
        return this.IPAMOptions;
    }
}
