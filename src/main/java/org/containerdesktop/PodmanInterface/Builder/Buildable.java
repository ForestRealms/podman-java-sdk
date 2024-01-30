package org.containerdesktop.PodmanInterface.Builder;

import java.net.SocketException;

public interface Buildable<T> {
    T build() throws SocketException;
}
