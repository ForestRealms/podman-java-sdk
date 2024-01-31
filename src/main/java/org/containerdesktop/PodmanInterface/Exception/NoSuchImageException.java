package org.containerdesktop.PodmanInterface.Exception;

import java.util.Map;

public class NoSuchImageException extends ImageInteractiveException{
    public NoSuchImageException(String key, String originalMessage, Map<String, String> replacementList, String image) {
        super(key, originalMessage, replacementList, image);
    }

    public NoSuchImageException(String key, Throwable cause, String originalMessage, Map<String, String> replacementList, String image) {
        super(key, cause, originalMessage, replacementList, image);
    }
}
