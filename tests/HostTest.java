import fr.itssky.asyncsocketlib.client.async.AsyncClient;
import fr.itssky.asyncsocketlib.client.handler.ClientHandler;
import fr.itssky.asyncsocketlib.exception.NullDataException;
import fr.itssky.asyncsocketlib.server.async.AsyncHost;
import fr.itssky.asyncsocketlib.server.handler.HostHandler;
import org.junit.Assert;
import org.junit.Test;

/**
 * The type Host test.
 *
 * @author ItsSky on 28/12/2020
 * @project AsyncSocketLib
 */
public class HostTest {
    public static final String SERV_MSG = "Welcome client !";
    public static final String CLI_MSG = "Welcome server !";

    private AsyncHost host;
    private HostHandler hostHandler;

    private AsyncClient client;
    private ClientHandler clientHandler;

    private int port;


    /**
     * Test the connection between a server and a client
     */
    @Test
    public void ConnectionTest() throws InterruptedException {

        this.connectionTest();

        this.client.disconnect();
        this.host.stop();
    }

    /**
     * Test a complete dialog between server and client
     */
    @Test
    public void DialogTest() throws InterruptedException {

        this.connectionTest();

        /**
         * SERVER SEND MESSAGE
         */

        this.host.sendMessage(HostTest.SERV_MSG);
        this.client.readMessage();

        try {
            Assert.assertEquals(HostTest.SERV_MSG, this.clientHandler.getData());
        } catch (NullDataException e) {
            e.printStackTrace();
            Assert.assertFalse(true);
        }

        /**
         * CLIENT SEND MESSAGE
         */

        this.client.sendMessage(HostTest.CLI_MSG);
        this.host.readMessage();

        try {
            Assert.assertEquals(HostTest.CLI_MSG, this.hostHandler.getData());
        } catch (NullDataException e) {
            e.printStackTrace();
            Assert.assertFalse(true);
        }

        this.client.disconnect();
        this.host.stop();
    }

    private void connectionTest() throws InterruptedException {
        this.port = 9000;

        /***
         * SERVER TEST
         */
        System.out.println("Server start");
        try {
            // HOST INIT
            this.hostHandler = new HostHandler();
            this.host = new AsyncHost(this.port, this.hostHandler);
            this.host.start();

            Assert.assertTrue(true);
        }catch (Exception e) {
            Assert.assertFalse(e.toString(), true);
        }

        /***
         * CLIENT TEST
         */
        System.out.println("Client start");
        try {
            // Client INIT
            this.clientHandler = new ClientHandler();
            this.client = new AsyncClient(this.clientHandler);
            this.client.connect(this.port, "127.0.0.1", 1000);

            Assert.assertTrue(true);
        }catch (Exception e) {
            Assert.assertFalse(e.toString(), true);
        }
    }
}
