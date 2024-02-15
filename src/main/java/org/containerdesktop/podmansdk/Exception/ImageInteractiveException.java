package org.containerdesktop.podmansdk.Exception;

import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;

public class ImageInteractiveException extends InteractiveException{
    public ImageInteractiveException(String key, String originalMessage, Map<String, String> replacementList, String image) {
        super(key, originalMessage, initMap(replacementList, image));
    }

    public ImageInteractiveException(String key, Throwable cause, String originalMessage, Map<String, String> replacementList, String image) {
        super(key, cause, originalMessage, initMap(replacementList, image));
    }

    private static Map<String, String> initMap(@Nullable Map<String, String> m, String image) {
        Map<String, String> map = new HashMap<>();
        map.put("%image%", image);
        if (m == null) {
            return map;
        }
        map.putAll(m);
        return map;
    }
}
