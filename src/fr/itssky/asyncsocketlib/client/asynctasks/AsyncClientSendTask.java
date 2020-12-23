package fr.itssky.asyncsocketlib.client.asynctasks;

import fr.itssky.asyncsocketlib.client.IClient;

/**
 * The type Async client send task.
 *
 * @param <T> the type parameter
 * @author ItsSky on 23/12/2020
 * @project AsyncSocketLib
 */
public class AsyncClientSendTask<T> extends AsyncClientTask<T> {
    private final T message;

    /**
     * Instantiates a new Async client send task.
     *
     * @param client  the client
     * @param message the message
     */
    public AsyncClientSendTask(IClient<T> client, T message) {
        super(client);
        this.message = message;
    }

    @Override
    public void run() {
        this.client.sendMessage(this.message);
    }
}
