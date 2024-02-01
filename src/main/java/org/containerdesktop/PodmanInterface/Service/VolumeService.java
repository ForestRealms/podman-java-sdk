package org.containerdesktop.PodmanInterface.Service;

import org.containerdesktop.PodmanInterface.Entity.Volume;

public interface VolumeService extends Service<Volume> {
    boolean exists(String name);
}
