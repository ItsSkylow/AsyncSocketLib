package fr.itssky.asyncsocketlib.client.asynctasks;

import fr.itssky.asyncsocketlib.client.IClient;

/**
 * The type Async client read task.
 *
 * @param <T> the type parameter
 * @author ItsSky on 23/12/2020
 * @project AsyncSocketLib
 */
public class AsyncClientReadTask<T> extends AsyncClientTask<T> {
    /**
     * Instantiates a new Async client read task.
     *
     * @param client the client
     */
    public AsyncClientReadTask(IClient<T> client) {
        super(client);
    }

    @Override
    public void run() {
        this.client.readMessage();
    }
}
