package org.containerdesktop.podmansdk.Exception;

import com.alibaba.fastjson2.JSONObject;

import java.util.Map;

public class InteractiveException extends PodmanSDKRuntimeException{
    private final String originalMessage;
    private final Map<String, String> replacementList;

    public InteractiveException(String key, String originalMessage, Map<String, String> replacementList) {
        super(key);
        this.originalMessage = originalMessage;
        this.replacementList = replacementList;
    }

    public InteractiveException(String key, Throwable cause, String originalMessage, Map<String, String> replacementList) {
        super(key, cause);
        this.originalMessage = originalMessage;
        this.replacementList = replacementList;
    }

    @Override
    public String getLocalizedMessage() {
        String localizedMessage = super.getLocalizedMessage();
        for (Map.Entry<String, String> entry : this.replacementList.entrySet()) {
            localizedMessage = localizedMessage.replaceAll(entry.getKey(), entry.getValue());
        }
        return localizedMessage;
    }

    public static String getErrorMessageFromResponse(String s) {
        return JSONObject.parse(s).getString("message");
    }

    public static String getCauseMessageFromResponse(String s) {
        return JSONObject.parse(s).getString("cause");
    }
}
