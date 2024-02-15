package org.containerdesktop.podmansdk.Configuration;

import org.containerdesktop.podmansdk.Entity.Container;
import org.containerdesktop.podmansdk.Entity.MessageKey;
import org.containerdesktop.podmansdk.Entity.PodmanContainer;
import org.containerdesktop.podmansdk.Exception.DuplicateEntryException;
import org.containerdesktop.podmansdk.Exception.DuplicateVolumePathException;

import java.util.HashMap;
import java.util.Map;

public class PodmanContainerConfig implements ContainerConfig {
    private String imageName;
    private String imageTag;
    private String name;
    private String command;
    private Map<String, String> environment = new HashMap<>();
    private Map<String, String> volumes = new HashMap<>();
    private Map<Integer, Integer> ports = new HashMap<>();
    private int cpuLimit;
    private int ramLimit;
    private int rootDiskLimit;

    /**
     * 获取镜像ID
     * @return 镜像ID
     */
    @Override
    public String getImageName() {
        return imageName;
    }

    /**
     * 获取容器名称
     * @return 容器名称
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * 获取容器启动命令
     * @return 容器启动命令
     */
    @Override
    public String getCommand() {
        return command;
    }

    /**
     * 获取环境变量
     * @return 环境变量列表
     */
    @Override
    public Map<String, String> getEnvironment() {
        return environment;
    }

    /**
     * 获取卷映射列表
     * @return 卷映射列表
     */
    @Override
    public Map<String, String> getVolumes() {
        return volumes;
    }

    /**
     * 获取端口映射列表
     * @return 端口映射列表
     */
    @Override
    public Map<Integer, Integer> getPorts() {
        return ports;
    }

    @Override
    public int getCpuLimit() {
        return cpuLimit;
    }

    @Override
    public int getRamLimit() {
        return ramLimit;
    }

    @Override
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public void setCpuLimit(int cpuLimit) {
        this.cpuLimit = cpuLimit;
    }

    @Override
    public void setRamLimit(int ramLimit) {
        this.ramLimit = ramLimit;
    }

    @Override
    public void addEnvironmentVariable(String name, String value){
        environment.put(name, value);
    }

    @Override
    public void addVolumeMapping(String hostPath, String containerPath) throws DuplicateVolumePathException {
        // 检查是否存在相同的主机路径
        if (volumes.containsKey(hostPath)) {
            throw new DuplicateVolumePathException(MessageKey.DUPLICATE_HOST_PATH.getKey());
        }

        // 检查是否存在相同的容器路径
        if (volumes.containsValue(containerPath)) {
            throw new DuplicateVolumePathException(MessageKey.DUPLICATE_CONTAINER_PATH.getKey());
        }

        // 添加卷映射
        volumes.put(hostPath, containerPath);
    }

    @Override
    public void addPortMapping(int hostPort, int containerPort) throws DuplicateEntryException {
        // 检查是否存在相同的主机端口
        if (ports.containsKey(hostPort)) {
            throw new DuplicateEntryException(MessageKey.DUPLICATE_HOST_PORT.getKey());
        }

        // 检查是否存在相同的容器端口
        if(ports.containsValue(containerPort)) {
            throw new DuplicateEntryException(MessageKey.DUPLICATE_CONTAINER_PORT.getKey());
        }

        // 添加端口映射
        ports.put(hostPort, containerPort);

    }

    @Override
    public int getRootDiskLimit() {
        return rootDiskLimit;
    }

    @Override
    public void setRootDiskLimit(int rootDiskLimit) {
        this.rootDiskLimit = rootDiskLimit;
    }

    @Override
    public String getImageTag() {
        return imageTag;
    }

    @Override
    public void setImageTag(String imageTag) {
        this.imageTag = imageTag;
    }

    @Override
    public Container getInstance() {
        // TODO 返回容器实例对象

        return null;
    }
}
