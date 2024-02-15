package org.containerdesktop.podmansdk.Builder;

import org.containerdesktop.podmansdk.Configuration.ContainerConfig;

public interface ContainerConfigBuilder extends Builder<ContainerConfig> {
    ContainerConfigBuilder name(String name);

    ContainerConfigBuilder image(String Name);

    ContainerConfigBuilder imageTag(String tag);

    ContainerConfigBuilder command(String command);

    ContainerConfigBuilder environment(String name, String value);

    ContainerConfigBuilder volume(String name, String containerPath);

    ContainerConfigBuilder port(int hostPort, int containerPort);

    ContainerConfigBuilder rootDiskLimit(int limit);
}
