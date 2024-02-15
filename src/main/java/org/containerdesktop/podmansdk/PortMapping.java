package org.containerdesktop.podmansdk;

public class PortMapping {
    private int hostPort;
    private int containerPort;

    public PortMapping(int hostPort, int containerPort) {
        this.hostPort = hostPort;
        this.containerPort = containerPort;
    }

    public int getHostPort() {
        return hostPort;
    }

    public void setHostPort(int hostPort) {
        this.hostPort = hostPort;
    }

    public int getContainerPort() {
        return containerPort;
    }

    public void setContainerPort(int containerPort) {
        this.containerPort = containerPort;
    }
}
