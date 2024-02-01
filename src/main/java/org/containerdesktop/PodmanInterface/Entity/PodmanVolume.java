package org.containerdesktop.PodmanInterface.Entity;

import com.alibaba.fastjson2.JSONObject;

import java.util.Date;
import java.util.Map;

public record PodmanVolume(String name,
                           Date createdDate,
                           Driver driver,
                           Map<String, String> labels,
                           String mountPoint,
                           Map<String, String> options,
                           int mountCount,
                           boolean needsCopyUp,
                           String scope) implements Volume {
    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public Driver getDriver() {
        return driver;
    }

    @Override
    public Map<String, String> getLabels() {
        return labels;
    }

    @Override
    public String getMountPoint() {
        return mountPoint;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Map<String, String> getOptions() {
        return options;
    }

    @Override
    public int getMountCount() {
        return mountCount;
    }

    @Override
    public boolean isNeedsCopyUp() {
        return needsCopyUp;
    }

    @Override
    public String getScope() {
        return scope;
    }



}
