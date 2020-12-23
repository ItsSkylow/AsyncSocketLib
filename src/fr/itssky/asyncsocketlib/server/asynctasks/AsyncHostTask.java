package fr.itssky.asyncsocketlib.server.asynctasks;

import fr.itssky.asyncsocketlib.server.IHost;

/**
 * The type Async host task.
 *
 * @param <T> the type parameter
 * @author ItsSky on 23/12/2020
 * @project AsyncSocketLib
 */
public abstract class AsyncHostTask<T> implements Runnable {
    /**
     * The Host.
     */
    protected IHost<T> host;

    /**
     * Instantiates a new Async host task.
     *
     * @param host the host
     */
    public AsyncHostTask(IHost<T> host){
        this.host = host;
    }

    @Override
    public abstract void run();
}
