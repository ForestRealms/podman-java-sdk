package org.containerdesktop.podmansdk.Entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

public record PodmanImage(String id,
                          String parentId,
                          List<String> repoTags,
                          List<String> repoDigests,
                          Date createdDate,
                          long size,
                          long virtualSize,
                          long sharedSize,
                          Map<String, String> labels,
                          int containerCount,
                          List<String> names,
                          String digest,
                          List<String> history) implements Image{

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getParentId() {
        return this.parentId;
    }

    @Override
    public List<String> getRepoTags() {
        return this.repoTags;
    }

    @Override
    public List<String> getRepoDigests() {
        return this.repoDigests;
    }

    @Override
    public Date getCreatedDate() {
        return this.createdDate;
    }

    @Override
    public long getSize() {
        return this.size;
    }

    @Override
    public long getVirtualSize() {
        return this.virtualSize;
    }

    @Override
    public long getSharedSize() {
        return this.sharedSize;
    }

    @Override
    public Map<String, String> getLabels() {
        return this.labels;
    }

    @Override
    public int getContainerCounts() {
        return this.containerCount;
    }

    @Override
    public List<String> getNames() {
        return this.names;
    }

    @Override
    public String getDigest() {
        return this.digest;
    }

    @Override
    public List<String> getHistory() {
        return this.history;
    }
}
