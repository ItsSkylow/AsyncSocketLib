package fr.itssky.asyncsocketlib.server.asynctasks;

import fr.itssky.asyncsocketlib.server.IHost;

/**
 * The type Async host stop task.
 *
 * @param <T> the type parameter
 * @author ItsSky on 23/12/2020
 * @project AsyncSocketLib
 */
public class AsyncHostStopTask<T> extends AsyncHostTask<T> {

    /**
     * Instantiates a new Async host stop task.
     *
     * @param host the host
     */
    public AsyncHostStopTask(IHost<T> host) {
        super(host);
    }

    @Override
    public void run() {
        this.host.stop();
    }
}
