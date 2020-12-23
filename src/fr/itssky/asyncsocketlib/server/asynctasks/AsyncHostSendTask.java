package fr.itssky.asyncsocketlib.server.asynctasks;

import fr.itssky.asyncsocketlib.server.IHost;

/**
 * The type Async host send task.
 *
 * @param <T> the type parameter
 * @author ItsSky on 23/12/2020
 * @project AsyncSocketLib
 */
public class AsyncHostSendTask<T> extends AsyncHostTask<T> {
    private final T message;

    /**
     * Instantiates a new Async host send task.
     *
     * @param host    the host
     * @param message the message
     */
    public AsyncHostSendTask(IHost<T> host, T message) {
        super(host);
        this.message = message;
    }

    @Override
    public void run() {
        this.host.sendMessage(this.message);
    }
}
