package org.containerdesktop.podmansdk.Builder;

import java.net.SocketException;

public interface Builder<T> {
    T build() throws SocketException;
}
