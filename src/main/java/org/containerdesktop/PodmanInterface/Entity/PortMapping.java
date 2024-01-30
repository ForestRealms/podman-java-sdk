package org.containerdesktop.PodmanInterface.Entity;

public interface PortMapping {
    String getHostIP();
    int getContainerPort();
    int getHostPort();
    int getRange();
    Protocol getProtocol();


    enum Protocol {
        TCP,
        UDP;
    }
}
