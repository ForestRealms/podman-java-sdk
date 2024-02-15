package org.containerdesktop.podmansdk.Service;

import org.containerdesktop.podmansdk.Entity.Image;

public interface ImageService extends Service<Image> {
    void pull(String fromImage, String tag);
}
