package fr.itssky.asyncsocketlib.client.asynctasks;

import fr.itssky.asyncsocketlib.client.IClient;

/**
 * The type Async client connect task.
 *
 * @param <T> the type parameter
 * @author ItsSky on 23/12/2020
 * @project AsyncSocketLib
 */
public class AsyncClientConnectTask<T> extends AsyncClientTask<T> {
    private final int port, timeout;
    private final String ip;

    /**
     * Instantiates a new Async client connect task.
     *
     * @param client  the client
     * @param port    the port
     * @param ip      the ip
     * @param timeout the timeout
     */
    public AsyncClientConnectTask(IClient<T> client, int port, String ip, int timeout) {
        super(client);
        this.port = port;
        this.ip = ip;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        this.client.connect(port, ip, timeout);
    }
}
