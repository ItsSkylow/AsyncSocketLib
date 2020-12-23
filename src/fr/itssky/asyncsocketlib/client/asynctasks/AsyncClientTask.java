package fr.itssky.asyncsocketlib.client.asynctasks;

import fr.itssky.asyncsocketlib.client.IClient;

/**
 * The type Async client task.
 *
 * @param <T> the type parameter
 * @author ItsSky on 23/12/2020
 * @project AsyncSocketLib
 */
public abstract class AsyncClientTask<T> implements Runnable {
    /**
     * The Client.
     */
    protected IClient<T> client;

    /**
     * Instantiates a new Async client task.
     *
     * @param client the client
     */
    public AsyncClientTask(IClient<T> client){
        this.client = client;
    }

    @Override
    public abstract void run();
}
