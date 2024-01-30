package org.containerdesktop.PodmanInterface.Entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface Container {
    boolean isAutoRemoved();
    List<String> getCommands();
    Date getCreatedDate();
    Date getCreatedAt();
    boolean isExited();
    Date getExitedAt();
    int getExitedCode();
    String getId();
    String getImageName();
    String getImageId();
    boolean isInfra();
    Map<String, String> getLabels();
    List<String> getMountPoints();
    List<String> getNames();
    Map<String, String> getNamespaces();
    List<Network> getNetworks();
    int getPID();
    String getPod();
    String getPodName();
    List<PortMapping> getPortMappings();
    Date getStartedAt();
    State getState();
    String getStatus();



    enum State {
        RUNNING,
        EXITED
    }

}
