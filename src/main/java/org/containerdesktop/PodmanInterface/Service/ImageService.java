package org.containerdesktop.PodmanInterface.Service;

import org.containerdesktop.PodmanInterface.Entity.Image;

public interface ImageService extends Service<Image> {
    void pull(String fromImage, String tag);
}
