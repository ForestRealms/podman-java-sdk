package org.containerdesktop.PodmanInterface;

import org.containerdesktop.PodmanInterface.Service.ContainerService;
import org.containerdesktop.PodmanInterface.Service.ImageService;
import org.containerdesktop.PodmanInterface.Service.NetworkService;
import org.containerdesktop.PodmanInterface.Service.VolumeService;

import java.net.SocketException;

public interface PodmanClient {
    NetworkService network();

    ContainerService container();
    ImageService image();
    VolumeService volume();

    class Builder implements org.containerdesktop.PodmanInterface.Builder.Builder<PodmanClient> {

        private String socket;
        private String version;
        private String hostAddr = "localhost";
        private boolean compat = true;

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

        public Builder compat(boolean enabled) {
            this.compat = enabled;
            return this;
        }
        


        @Override
        public PodmanClient build() throws SocketException {
            String libpod = "";
            if (!compat) {
                libpod = "/libpod";
            }
            return new SimplePodmanClient(this.socket, "http://" + this.hostAddr + "/v" + this.version + libpod, this.compat);
        }
    }




}
