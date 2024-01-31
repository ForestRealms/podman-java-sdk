import org.containerdesktop.PodmanInterface.Builder.DefaultNetworkConfigBuilder;
import org.containerdesktop.PodmanInterface.Entity.Network;
import org.containerdesktop.PodmanInterface.Exception.NoSuchNetworkException;
import org.containerdesktop.PodmanInterface.PodmanClient;
import org.junit.jupiter.api.*;



import java.net.SocketException;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NetworkTest {

    private final PodmanClient client = new PodmanClient.Builder()
            .compat(true)
            .socket("/run/podman/podman.sock")
            .version("4.4.1")
            .build();

    private static List<Network> list;

    public NetworkTest() throws SocketException {
    }

    @Test
    @Order(1)
    @DisplayName("列出所有网络")
    public void listNetwork(){
        list = this.client.network().list();
    }

    @Test
    @Order(2)
    @DisplayName("添加网络")
    public void addNetwork() {
        Assertions.assertDoesNotThrow(() -> this.client.network().create(new DefaultNetworkConfigBuilder()
                        .name("test")
                        .driver(Network.Driver.BRIDGE)
                .build()));
    }

    @Test
    @Order(3)
    @DisplayName("检查添加网络后的数量")
    public void checkNumber(){
        Assertions.assertEquals(list.size() + 1, this.client.network().list().size());
        Assertions.assertEquals("test", this.client.network().get("test").getName());
    }

    @Test
    @Order(4)
    @DisplayName("删除网络")
    public void removeNetwork(){
        Assertions.assertDoesNotThrow(() -> {
            this.client.network().delete("test");
        });
    }

    @Test
    @Order(5)
    @DisplayName("检查删除是否成功")
    public void checkRemoved() {
        Assertions.assertEquals(list.size(), this.client.network().list().size());
        Assertions.assertThrows(NoSuchNetworkException.class, () -> {
            this.client.network().get("test");
        });
    }


}
