package org.containerdesktop.podmansdk.Configuration;

import org.containerdesktop.podmansdk.Entity.PodmanVolume;
import org.containerdesktop.podmansdk.Entity.Volume;

import java.util.Date;
import java.util.Map;

public class PodmanVolumeConfig implements VolumeConfig{
    private PodmanVolume volume;

    private Date createdDate;
    private Volume.Driver driver;
    private Map<String, String> labels;
    private String mountPoint;
    private String name;
    private Map<String, String> options;
    private int mountCount;
    private boolean needsCopyUp;
    private String scope;

    @Override
    public PodmanVolume getVolume() {
        return volume;
    }

    @Override
    public void setVolume(PodmanVolume volume) {
        this.volume = volume;
    }

    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public Volume.Driver getDriver() {
        return driver;
    }

    @Override
    public void setDriver(Volume.Driver driver) {
        this.driver = driver;
    }

    @Override
    public Map<String, String> getLabels() {
        return labels;
    }

    @Override
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    @Override
    public String getMountPoint() {
        return mountPoint;
    }

    @Override
    public void setMountPoint(String mountPoint) {
        this.mountPoint = mountPoint;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Map<String, String> getOptions() {
        return options;
    }

    @Override
    public void setOptions(Map<String, String> options) {
        this.options = options;
    }

    @Override
    public int getMountCount() {
        return mountCount;
    }

    @Override
    public void setMountCount(int mountCount) {
        this.mountCount = mountCount;
    }

    @Override
    public boolean isNeedsCopyUp() {
        return needsCopyUp;
    }

    @Override
    public void setNeedsCopyUp(boolean needsCopyUp) {
        this.needsCopyUp = needsCopyUp;
    }

    @Override
    public String getScope() {
        return scope;
    }

    @Override
    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public Volume getInstance() {
        return new PodmanVolume(name, createdDate, driver, labels
        , mountPoint, options, mountCount, needsCopyUp, scope);
    }
}
