package org.containerdesktop.podmansdk.Exception;

import java.util.Map;

public class NoSuchNetworkException extends NetworkInteractiveException {
    public NoSuchNetworkException(String key, String originalMessage, String network, Map<String, String> replacementList) {
        super(key, originalMessage, network, replacementList);
    }

    public NoSuchNetworkException(String key, String originalMessage, String network) {
        super(key, originalMessage, network);
    }

    public NoSuchNetworkException(String key, Throwable cause, String originalMessage, Map<String, String> replacementList) {
        super(key, cause, originalMessage, replacementList);
    }
}
