package org.containerdesktop.podmansdk.Service;

import org.containerdesktop.podmansdk.Entity.Volume;

public interface VolumeService extends Service<Volume> {
    boolean exists(String name);
}
