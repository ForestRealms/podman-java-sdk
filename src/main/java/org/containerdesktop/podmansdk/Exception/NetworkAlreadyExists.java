package org.containerdesktop.podmansdk.Exception;

import java.util.Map;

public class NetworkAlreadyExists extends NetworkInteractiveException{

    public NetworkAlreadyExists(String key, String originalMessage, String network, Map<String, String> replacementList) {
        super(key, originalMessage, network, replacementList);
    }

    public NetworkAlreadyExists(String key, String originalMessage, String network) {
        super(key, originalMessage, network);
    }

    public NetworkAlreadyExists(String key, Throwable cause, String originalMessage, Map<String, String> replacementList) {
        super(key, cause, originalMessage, replacementList);
    }
}
