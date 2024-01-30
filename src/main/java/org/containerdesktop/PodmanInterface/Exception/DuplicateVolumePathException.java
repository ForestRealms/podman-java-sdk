package org.containerdesktop.PodmanInterface.Exception;

public class DuplicateVolumePathException extends DuplicateEntryException{
    public DuplicateVolumePathException() {
    }

    public DuplicateVolumePathException(String key) {
        super(key);
    }

    public DuplicateVolumePathException(String key, Throwable cause) {
        super(key, cause);
    }
}
