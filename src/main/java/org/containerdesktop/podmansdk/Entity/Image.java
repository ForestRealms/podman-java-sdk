package org.containerdesktop.podmansdk.Entity;

import com.alibaba.fastjson2.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface Image {
    String getId();
    String getParentId();
    List<String> getRepoTags();
    List<String> getRepoDigests();
    Date getCreatedDate();
    long getSize();
    long getVirtualSize();
    long getSharedSize();
    Map<String, String> getLabels();
    int getContainerCounts();
    List<String> getNames();
    String getDigest();
    List<String> getHistory();


    static Image parse(JSONObject jsonObject) {
        String[] t = jsonObject.getString("Id").split(":");
        String id = t[t.length-1];
        t = jsonObject.getString("ParentId").split(":");
        String parentId = t[t.length-1];
        List<String> repoTags = jsonObject.getJSONArray("RepoTags").toJavaList(String.class);
        List<String> repoDigests = jsonObject.getJSONArray("RepoDigests").toJavaList(String.class);
        Date createdDate = new Date(jsonObject.getLong("Created"));
        long size = jsonObject.getLongValue("Size", 0);
        long sharedSize = jsonObject.getLongValue("SharedSize", 0);
        long virtualSize = jsonObject.getLongValue("VirtualSize", 0);
        JSONObject l = jsonObject.getJSONObject("Labels");
        Map<String, String> labels = new HashMap<>();
        if (l != null) {
            labels = l.keySet().stream().collect(Collectors.toMap(
                            key -> key,
                            l::getString
                    ));
        }
        int containerCount = jsonObject.getInteger("Containers");
        List<String> names = jsonObject.getJSONArray("Names").toJavaList(String.class);
        String digest = jsonObject.getString("Digest");
        List<String> history = jsonObject.getJSONArray("History").toJavaList(String.class);
        return new PodmanImage(id, parentId, repoTags, repoDigests, createdDate, size, virtualSize, sharedSize, labels, containerCount, names, digest, history);


    }
}
