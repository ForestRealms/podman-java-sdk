package org.containerdesktop.PodmanInterface.Exception;

import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;

public class VolumeInteractiveException extends InteractiveException{
    public VolumeInteractiveException(String key, String originalMessage, String volume, Map<String, String> replacementList) {
        super(key, originalMessage, initMap(replacementList, volume));
    }

    public VolumeInteractiveException(String key, Throwable cause, String originalMessage, String volume, Map<String, String> replacementList) {
        super(key, cause, originalMessage, initMap(replacementList, volume));
    }

    private static Map<String, String> initMap(@Nullable Map<String, String> m, String volume) {
        Map<String, String> map = new HashMap<>();
        map.put("%volume%", volume);
        if (m == null) {
            return map;
        }
        map.putAll(m);
        return map;
    }
}
