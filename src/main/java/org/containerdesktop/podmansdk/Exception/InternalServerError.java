package org.containerdesktop.podmansdk.Exception;

import java.util.Map;

public class InternalServerError extends InteractiveException{


    public InternalServerError(String key, String originalMessage) {
        super(key, originalMessage, Map.of("%msg%", originalMessage));
    }

    public InternalServerError(String key, Throwable cause, String originalMessage) {
        super(key, cause, originalMessage, Map.of("%msg%", originalMessage));
    }
}
