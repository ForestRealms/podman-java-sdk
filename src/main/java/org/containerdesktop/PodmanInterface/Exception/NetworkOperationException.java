package org.containerdesktop.PodmanInterface.Exception;

public class NetworkOperationException extends PodmanSDKRuntimeException{

    private final Reason reason;
    private final String originalMessage;

    public NetworkOperationException(String key, Reason reason, String originalMessage) {
        super(key);
        this.reason = reason;
        this.originalMessage = originalMessage;
    }

    public NetworkOperationException(String key, Throwable cause, Reason reason, String originalMessage) {
        super(key, cause);
        this.reason = reason;
        this.originalMessage = originalMessage;
    }

    public Reason getReason() {
        return reason;
    }

    public String getOriginalMessage() {
        return originalMessage;
    }

    public enum Reason {
        NETWORK_ALREADY_EXISTS,
        UNKNOWN
    }
}
