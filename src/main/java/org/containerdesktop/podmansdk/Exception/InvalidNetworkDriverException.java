package org.containerdesktop.podmansdk.Exception;

public class InvalidNetworkDriverException extends PodmanSDKRuntimeException{

    private String invalid;

    public InvalidNetworkDriverException(String key) {
        super(key);
    }

    public InvalidNetworkDriverException(String key, String invalid) {
        super(key);
        this.invalid = invalid;
    }

    public InvalidNetworkDriverException(String key, Throwable cause) {
        super(key, cause);
    }

    @Override
    public String getLocalizedMessage() {
        if (this.invalid != null) {
            return super.getLocalizedMessage().replaceAll("%driver%", this.invalid);
        }else {
            return super.getLocalizedMessage();
        }

    }
}
