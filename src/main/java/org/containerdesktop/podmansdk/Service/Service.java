package org.containerdesktop.podmansdk.Service;

import org.containerdesktop.podmansdk.Configuration.Config;

import java.io.IOException;
import java.util.List;

public interface Service<T> {


    String create(Config<T> config) throws IOException;
    void delete(String name);
    List<T> list();
    T get(String name);
}
