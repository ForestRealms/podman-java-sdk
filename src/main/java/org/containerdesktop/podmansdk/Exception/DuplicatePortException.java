package org.containerdesktop.podmansdk.Exception;

public class DuplicatePortException extends DuplicateEntryException{
    public DuplicatePortException() {
    }

    public DuplicatePortException(String key) {
        super(key);
    }

    public DuplicatePortException(String key, Throwable cause) {
        super(key, cause);
    }
}
