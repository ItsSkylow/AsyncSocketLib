package fr.itssky.asyncsocketlib.client.async;

import fr.itssky.asyncsocketlib.client.IClient;
import fr.itssky.asyncsocketlib.client.asynctasks.AsyncClientReadTask;
import fr.itssky.asyncsocketlib.client.asynctasks.AsyncClientSendTask;
import fr.itssky.asyncsocketlib.client.asynctasks.AsyncClientConnectTask;
import fr.itssky.asyncsocketlib.client.asynctasks.AsyncClientDisconnectTask;
import fr.itssky.asyncsocketlib.client.handler.IClientHandler;
import fr.itssky.asyncsocketlib.client.sync.Client;
import fr.itssky.asyncsocketlib.exception.ClientException;

/**
 * The type Async client.
 *
 * @author ItsSky on 23/12/2020
 * @project AsyncSocketLib
 */
public class AsyncClient implements IClient<String> {
    private final Client client;
    private Thread task;

    /**
     * Instantiates a new Async client.
     *
     * @param handler the handler
     */
    public AsyncClient(IClientHandler<String> handler) {
        this.client = new Client(handler);
    }

    @Override
    public void connect(int port, String ip, int timeout) {
        this.task = new Thread(new AsyncClientConnectTask<>(this.client, port, ip, timeout));
        // Start the host
        this.task.start();
    }

    @Override
    public void disconnect() {
        try {
            // Wait end of task thread
            this.task.join();
            // Stop the host
            this.task = new Thread(new AsyncClientDisconnectTask<>(this.client));
            this.task.start();
        } catch (InterruptedException e) {
            this.client.getHandler().didDisconnect(new ClientException(e.getMessage()));
        }
    }

    @Override
    public void sendMessage(String message) {
        // Wait end of task thread
        try {
            // Wait end of task thread
            this.task.join();
            // Send message
            this.task = new Thread(new AsyncClientSendTask<>(this.client, message));
            this.task.start();
        } catch (InterruptedException e) {
            this.client.getHandler().didSendData(null);
        }
    }

    @Override
    public void readMessage() {
        try {
            // Wait end of task thread
            this.task.join();
            // Read receive message
            this.task = new Thread(new AsyncClientReadTask<>(this.client));
            this.task.start();
        } catch (InterruptedException e) {
            this.client.getHandler().didReceiveData(null);
        }
    }
}
