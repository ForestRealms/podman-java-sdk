package org.containerdesktop.PodmanInterface.Builder;

import org.containerdesktop.PodmanInterface.Configuration.ContainerConfig;

public interface ContainerConfigBuilder extends Buildable<ContainerConfig> {
    ContainerConfigBuilder name(String name);

    ContainerConfigBuilder image(String Name);

    ContainerConfigBuilder imageTag(String tag);

    ContainerConfigBuilder command(String command);

    ContainerConfigBuilder environment(String name, String value);

    ContainerConfigBuilder volume(String name, String containerPath);

    ContainerConfigBuilder port(int hostPort, int containerPort);

    ContainerConfigBuilder rootDiskLimit(int limit);
}
