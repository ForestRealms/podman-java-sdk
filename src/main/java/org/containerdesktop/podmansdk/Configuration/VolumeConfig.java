package org.containerdesktop.podmansdk.Configuration;

import org.containerdesktop.podmansdk.Entity.PodmanVolume;
import org.containerdesktop.podmansdk.Entity.Volume;

import java.util.Date;
import java.util.Map;

public interface VolumeConfig extends Config<Volume> {
    PodmanVolume getVolume();

    void setVolume(PodmanVolume volume);

    Date getCreatedDate();

    void setCreatedDate(Date createdDate);

    Volume.Driver getDriver();

    void setDriver(Volume.Driver driver);

    Map<String, String> getLabels();

    void setLabels(Map<String, String> labels);

    String getMountPoint();

    void setMountPoint(String mountPoint);

    String getName();

    void setName(String name);

    Map<String, String> getOptions();

    void setOptions(Map<String, String> options);

    int getMountCount();

    void setMountCount(int mountCount);

    boolean isNeedsCopyUp();

    void setNeedsCopyUp(boolean needsCopyUp);

    String getScope();

    void setScope(String scope);
}
