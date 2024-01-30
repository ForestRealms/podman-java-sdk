package org.containerdesktop.PodmanInterface.Entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface Image {
    String getId();
    String getParentId();
    List<String> getRepoTags();
    List<String> getRepoDigests();
    Date getCreatedDate();
    int getSize();
    int getVirtualSize();
    int getSharedSize();
    Map<String, String> getLabels();
    int getContainerCounts();
    List<String> getNames();
    String getDigest();
    List<String> getHistory();



}
