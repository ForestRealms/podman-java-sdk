package org.containerdesktop.PodmanInterface.Builder;

import org.containerdesktop.PodmanInterface.Configuration.ContainerConfig;
import org.containerdesktop.PodmanInterface.Configuration.PodmanContainerConfig;
import org.containerdesktop.PodmanInterface.Exception.DuplicateEntryException;
import org.containerdesktop.PodmanInterface.Exception.DuplicateVolumePathException;


public class DefaultContainerConfigBuilder implements ContainerConfigBuilder {

    private final ContainerConfig config = new PodmanContainerConfig();

    @Override
    public ContainerConfigBuilder name(String name){
        this.config.setName(name);
        return this;
    }

    @Override
    public ContainerConfigBuilder image(String name){
        this.config.setImageName(name);
        return this;
    }

    @Override
    public ContainerConfigBuilder imageTag(String tag){
        this.config.setImageTag(tag);
        return this;
    }

    @Override
    public ContainerConfigBuilder command(String command){
        this.config.setCommand(command);
        return this;
    }

    @Override
    public ContainerConfigBuilder environment(String name, String value){
        this.config.addEnvironmentVariable(name, value);
        return this;
    }

    @Override
    public ContainerConfigBuilder volume(String name, String containerPath) {
        try {
            this.config.addVolumeMapping(name, containerPath);
        } catch (DuplicateVolumePathException e) {
            throw new RuntimeException(e.getLocalizedMessage(), e);
        }
        return this;
    }

    @Override
    public ContainerConfigBuilder port(int hostPort, int containerPort) {
        try {
            this.config.addPortMapping(hostPort, containerPort);
        } catch (DuplicateEntryException e) {
            throw new RuntimeException(e.getLocalizedMessage(), e);
        }
        return this;
    }

    @Override
    public ContainerConfigBuilder rootDiskLimit(int limit){
        this.config.setRootDiskLimit(limit);
        return this;
    }


    @Override
    public ContainerConfig build() {
        return this.config;
    }


}
