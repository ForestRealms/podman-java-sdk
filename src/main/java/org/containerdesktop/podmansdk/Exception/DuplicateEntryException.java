package org.containerdesktop.podmansdk.Exception;

public class DuplicateEntryException extends PodmanSDKException{
    public DuplicateEntryException() {
    }

    public DuplicateEntryException(String key) {
        super(key);
    }

    public DuplicateEntryException(String key, Throwable cause) {
        super(key, cause);
    }
}
