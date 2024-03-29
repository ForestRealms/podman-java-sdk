package org.containerdesktop.PodmanInterface;

import org.containerdesktop.PodmanInterface.Builder.Buildable;
import org.containerdesktop.PodmanInterface.Service.ContainerService;
import org.containerdesktop.PodmanInterface.Service.NetworkService;

import java.net.SocketException;

public interface PodmanClient {
    NetworkService network();

    ContainerService container();

    class Builder implements Buildable<PodmanClient> {

        private String socket;
        private String version;
        private String hostAddr = "localhost";

        public Builder socket(String socket){
            this.socket = socket;
            return this;
        }

        public Builder version(String version) {
            this.version = version;
            return this;
        }

        public Builder host(String addr) {
            this.hostAddr = addr;
            return this;
        }
        


        @Override
        public PodmanClient build() throws SocketException {
            return new SimplePodmanClient(this.socket, "http://" + this.hostAddr + "/v" + this.version);
        }
    }




}
