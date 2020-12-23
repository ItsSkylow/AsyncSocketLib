package fr.itssky.asyncsocketlib.server.asynctasks;

import fr.itssky.asyncsocketlib.server.IHost;

/**
 * The type Async host read task.
 *
 * @param <T> the type parameter
 * @author ItsSky on 23/12/2020
 * @project AsyncSocketLib
 */
public class AsyncHostReadTask<T> extends AsyncHostTask<T> {
    /**
     * Instantiates a new Async host read task.
     *
     * @param host the host
     */
    public AsyncHostReadTask(IHost<T> host) {
        super(host);
    }

    @Override
    public void run() {
        this.host.readMessage();
    }
}
