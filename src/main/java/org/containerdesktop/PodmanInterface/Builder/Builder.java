package org.containerdesktop.PodmanInterface.Builder;

import java.net.SocketException;

public interface Builder<T> {
    T build() throws SocketException;
}
