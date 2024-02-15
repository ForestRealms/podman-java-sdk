package org.containerdesktop.podmansdk.Exception;

import java.util.Map;

public class VolumeIsInUseException extends VolumeInteractiveException{
    public VolumeIsInUseException(String key, String originalMessage, String volume, Map<String, String> replacementList) {
        super(key, originalMessage, volume, replacementList);
    }

    public VolumeIsInUseException(String key, Throwable cause, String originalMessage, String volume, Map<String, String> replacementList) {
        super(key, cause, originalMessage, volume, replacementList);
    }
}
