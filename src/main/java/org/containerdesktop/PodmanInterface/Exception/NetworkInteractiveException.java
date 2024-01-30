package org.containerdesktop.PodmanInterface.Exception;

import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;

public class NetworkInteractiveException extends InteractiveException{
    public NetworkInteractiveException(String key, String originalMessage, String network, Map<String, String> replacementList) {
        super(key, originalMessage, initMap(replacementList, network));
    }

    public NetworkInteractiveException(String key, String originalMessage, String network) {
        super(key, originalMessage, initMap(null, network));
    }

    public NetworkInteractiveException(String key, Throwable cause, String originalMessage, Map<String, String> replacementList) {
        super(key, cause, originalMessage, replacementList);
    }

    private static Map<String, String> initMap(@Nullable Map<String, String> m, String network) {
        Map<String, String> map = new HashMap<>();
        map.put("%network%", network);
        if (m == null) {
            return map;
        }
        map.putAll(m);
        return map;
    }
}
