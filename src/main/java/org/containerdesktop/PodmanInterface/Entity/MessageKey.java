package org.containerdesktop.PodmanInterface.Entity;

public enum MessageKey {
    DUPLICATE_HOST_PATH("duplicateHostPathError"),

    DUPLICATE_CONTAINER_PATH("duplicateContainerPathError"),
    DUPLICATE_CONTAINER_PORT("duplicateContainerPortError"),
    DUPLICATE_HOST_PORT("duplicateHostPortError");

    private final String key;

    MessageKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }


}
