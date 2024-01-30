package org.containerdesktop.PodmanInterface.Configuration;

import org.containerdesktop.PodmanInterface.Entity.Container;
import org.containerdesktop.PodmanInterface.Exception.DuplicateEntryException;
import org.containerdesktop.PodmanInterface.Exception.DuplicateVolumePathException;

import java.util.Map;

public interface ContainerConfig extends Config<Container> {
    String getImageName();

    String getName();

    String getCommand();

    Map<String, String> getEnvironment();

    Map<String, String> getVolumes();

    Map<Integer, Integer> getPorts();

    int getCpuLimit();

    int getRamLimit();

    void setImageName(String imageName);

    void setName(String name);

    void setCommand(String command);

    void setCpuLimit(int cpuLimit);

    void setRamLimit(int ramLimit);

    void addEnvironmentVariable(String name, String value);

    void addVolumeMapping(String hostPath, String containerPath) throws DuplicateVolumePathException;

    void addPortMapping(int hostPort, int containerPort) throws DuplicateEntryException;

    int getRootDiskLimit();

    void setRootDiskLimit(int rootDiskLimit);

    String getImageTag();

    void setImageTag(String imageTag);
}
