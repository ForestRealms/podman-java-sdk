package org.containerdesktop.podmansdk.Entity;

import com.alibaba.fastjson2.JSONObject;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

public interface Volume extends PodmanResource{

    Date getCreatedDate();
    Driver getDriver();
    Map<String, String> getLabels();
    String getMountPoint();
    String getName();
    Map<String, String> getOptions();
    int getMountCount();
    boolean isNeedsCopyUp();
    String getScope();

    static Volume parse(JSONObject jsonObject) {
        Date createdDate = Date.from(OffsetDateTime.parse(jsonObject.getString("CreatedAt"), DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant());
        Driver driver = switch (jsonObject.getString("Driver")) {
            case "lcoal" -> Driver.LOCAL;
            case "image" -> Driver.IMAGE;
            default -> Driver.OTHER.setValue(jsonObject.getString("Driver"));
        };
        JSONObject l = jsonObject.getJSONObject("Labels");
        Map<String, String> labels = l.keySet().stream()
                .collect(Collectors.toMap(
                        key -> key,
                        l::getString
                ));
        String mountPoint = jsonObject.getString("Mountpoint");
        String name = jsonObject.getString("Name");
        JSONObject o = jsonObject.getJSONObject("Options");
        Map<String, String> options = o.keySet().stream()
                .collect(Collectors.toMap(
                        key -> key,
                        o::getString
                ));
        String scope = jsonObject.getString("Scope");
        boolean needsCopyUp = true;
        if(jsonObject.containsKey("NeedsCopyUp")) {
            needsCopyUp = jsonObject.getBooleanValue("NeedsCopyUp");
        }
        // 当处于libpod模式（compat = false）时才可获取到挂载数量
        int mountCount = 0;
        if (jsonObject.containsKey("MountCount")) {
            mountCount = jsonObject.getInteger("MountCount");
        }
        return new PodmanVolume(name, createdDate,
                driver, labels,
                mountPoint, options,
                mountCount, needsCopyUp, scope);
    }


    public enum Driver {
        /**
         * Uses a directory on disk as the backend (by default).
         */
        LOCAL("local"),
        /**
         * Using an image as the backing store of for the volume.
         */
        IMAGE("image"),
        /**
         * Must set the value before using, this option will
         * attempt to create the volume using a volume plugin
         * with the given name. Such plugins must be defined
         * in the volume_plugins section of the `containers.conf`
         * configuration file
         */
        OTHER(null);

        private String value;

        Driver(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }

        public Driver setValue(String value) {
            this.value = value;
            return this;
        }


    }
}
