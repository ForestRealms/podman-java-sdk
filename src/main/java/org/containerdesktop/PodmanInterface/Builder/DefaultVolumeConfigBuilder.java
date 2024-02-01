package org.containerdesktop.PodmanInterface.Builder;

import org.containerdesktop.PodmanInterface.Configuration.PodmanVolumeConfig;
import org.containerdesktop.PodmanInterface.Configuration.VolumeConfig;
import org.containerdesktop.PodmanInterface.Entity.Volume;

import java.net.SocketException;
import java.util.HashMap;

public class DefaultVolumeConfigBuilder implements VolumeConfigBuilder{
    private final VolumeConfig config = new PodmanVolumeConfig() {{
        setDriver(Volume.Driver.LOCAL);
        setScope("local");
        setLabels(new HashMap<>());
        setOptions(new HashMap<>());
    }};

    public VolumeConfigBuilder name(String name){
        this.config.setName(name);
        return this;
    }

    public VolumeConfigBuilder driver(Volume.Driver driver) {
        this.config.setDriver(driver);
        return this;
    }

    public VolumeConfigBuilder addLabel(String key, String value) {
        this.config.getLabels().put(key, value);
        return this;
    }

    public VolumeConfigBuilder addOptions(String key, String value) {
        this.config.getOptions().put(key, value);
        return this;
    }

    private VolumeConfigBuilder scope(String scope) {
        this.config.setScope(scope);
        return this;
    }

    @Override
    public VolumeConfig build() throws SocketException {
        return this.config;
    }
}
