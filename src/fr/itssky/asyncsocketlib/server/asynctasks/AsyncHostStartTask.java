package fr.itssky.asyncsocketlib.server.asynctasks;

import fr.itssky.asyncsocketlib.server.IHost;

/**
 * The type Async host start task.
 *
 * @param <T> the type parameter
 * @author ItsSky on 23/12/2020
 * @project AsyncSocketLib
 */
public class AsyncHostStartTask<T> extends AsyncHostTask<T> {
    private final int port;

    /**
     * Instantiates a new Async host start task.
     *
     * @param host the host
     * @param port the port
     */
    public AsyncHostStartTask(IHost<T> host, int port) {
        super(host);
        this.port = port;
    }

    @Override
    public void run() {
        this.host.start(this.port);
    }
}
