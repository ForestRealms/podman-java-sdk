package org.containerdesktop.podmansdk.Exception;

import java.util.Map;

public class NoSuchVolumeException extends VolumeInteractiveException{
    public NoSuchVolumeException(String key, String originalMessage, String volume, Map<String, String> replacementList) {
        super(key, originalMessage, volume, replacementList);
    }

    public NoSuchVolumeException(String key, Throwable cause, String originalMessage, String volume, Map<String, String> replacementList) {
        super(key, cause, originalMessage, volume, replacementList);
    }
}
