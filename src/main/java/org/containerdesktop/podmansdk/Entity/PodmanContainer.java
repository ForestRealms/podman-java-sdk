package org.containerdesktop.podmansdk.Entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class PodmanContainer implements Container{
    @Override
    public boolean isAutoRemoved() {
        return false;
    }

    @Override
    public List<String> getCommands() {
        return null;
    }

    @Override
    public Date getCreatedDate() {
        return null;
    }

    @Override
    public Date getCreatedAt() {
        return null;
    }

    @Override
    public boolean isExited() {
        return false;
    }

    @Override
    public Date getExitedAt() {
        return null;
    }

    @Override
    public int getExitedCode() {
        return 0;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getImageName() {
        return null;
    }

    @Override
    public String getImageId() {
        return null;
    }

    @Override
    public boolean isInfra() {
        return false;
    }

    @Override
    public Map<String, String> getLabels() {
        return null;
    }

    @Override
    public List<String> getMountPoints() {
        return null;
    }

    @Override
    public List<String> getNames() {
        return null;
    }

    @Override
    public Map<String, String> getNamespaces() {
        return null;
    }

    @Override
    public List<Network> getNetworks() {
        return null;
    }

    @Override
    public int getPID() {
        return 0;
    }

    @Override
    public String getPod() {
        return null;
    }

    @Override
    public String getPodName() {
        return null;
    }

    @Override
    public List<PortMapping> getPortMappings() {
        return null;
    }

    @Override
    public Date getStartedAt() {
        return null;
    }

    @Override
    public State getState() {
        return null;
    }

    @Override
    public String getStatus() {
        return null;
    }
}
