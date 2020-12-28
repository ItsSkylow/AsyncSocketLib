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
    /**
     * Instantiates a new Async host start task.
     *
     * @param host the host
     */
    public AsyncHostStartTask(IHost<T> host) {
        super(host);
    }

    @Override
    public void run() {
        this.host.start();
    }
}
