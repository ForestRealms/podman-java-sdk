package org.containerdesktop.podmansdk.Exception;

import java.util.Locale;
import java.util.ResourceBundle;

public abstract class PodmanSDKRuntimeException extends RuntimeException{

    public PodmanSDKRuntimeException(String key) {
        super(key);
    }

    public PodmanSDKRuntimeException(String key, Throwable cause) {
        super(key, cause);
    }

    @Override
    public String getLocalizedMessage() {
        Locale defaultLocale = Locale.getDefault();
        ResourceBundle bundle = ResourceBundle.getBundle("message/message", defaultLocale);
        return bundle.getString(this.getMessage());
    }
}
