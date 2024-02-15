package org.containerdesktop.podmansdk.Entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

public record PodmanContainer(    List<String> commands,
                                  Date createdDate,
                                  Date createdAt,
                                  boolean exited,
                                  Date exitedAt,
                                  int exitedCode,
                                  String id, // 更改驼峰命名以匹配Java记录字段规范（通常是小写字母）
                                  String imageName,
                                  String imageId,
                                  boolean infra,
                                  boolean autoRemoved,
                                  Map<String, String> labels,
                                  List<String> mountPoints,
                                  List<String> names,
                                  Map<String, String> namespaces,
                                  List<Network> networks,
                                  int pid,
                                  String pod,
                                  String podName,
                                  List<PortMapping> portMappings,
                                  Date startedAt,
                                  State state,
                                  String status)
        implements Container{
    @Override
    public boolean isAutoRemoved() {
        return this.autoRemoved;
    }

    @Override
    public List<String> getCommands() {
        return this.commands;
    }

    @Override
    public Date getCreatedDate() {
        return this.createdDate;
    }

    @Override
    public Date getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public boolean isExited() {
        return this.exited;
    }

    @Override
    public Date getExitedAt() {
        return this.exitedAt;
    }

    @Override
    public int getExitedCode() {
        return this.exitedCode;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getImageName() {
        return this.imageName;
    }

    @Override
    public String getImageId() {
        return this.imageId;
    }

    @Override
    public boolean isInfra() {
        return this.infra;
    }

    @Override
    public Map<String, String> getLabels() {
        return this.labels;
    }

    @Override
    public List<String> getMountPoints() {
        return this.mountPoints;
    }

    @Override
    public List<String> getNames() {
        return this.names;
    }

    @Override
    public Map<String, String> getNamespaces() {
        return this.namespaces;
    }

    @Override
    public List<Network> getNetworks() {
        return this.networks;
    }

    @Override
    public int getPID() {
        return this.pid;
    }

    @Override
    public String getPod() {
        return this.pod;
    }

    @Override
    public String getPodName() {
        return this.podName;
    }

    @Override
    public List<PortMapping> getPortMappings() {
        return this.portMappings;
    }

    @Override
    public Date getStartedAt() {
        return this.startedAt;
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public String getStatus() {
        return this.status;
    }
}
