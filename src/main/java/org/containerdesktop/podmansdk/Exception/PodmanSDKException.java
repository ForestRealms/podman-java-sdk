package org.containerdesktop.podmansdk.Exception;

import java.util.Locale;
import java.util.ResourceBundle;

public class PodmanSDKException extends Exception{

    public PodmanSDKException() {
    }

    public PodmanSDKException(String key) {
        super(key);
    }

    public PodmanSDKException(String key, Throwable cause) {
        super(key, cause);
    }

    @Override
    public String getLocalizedMessage() {
        Locale defaultLocale = Locale.getDefault();
        ResourceBundle bundle = ResourceBundle.getBundle("message/message", defaultLocale);
        return bundle.getString(this.getMessage());
    }


}
