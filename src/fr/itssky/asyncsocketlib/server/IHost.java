package fr.itssky.asyncsocketlib.server;

/**
 * The interface Host.
 *
 * @param <T> the type parameter
 * @author ItsSky on 23/12/2020
 * @project AsyncSocketLib
 */
public interface IHost<T> {
    /**
     * Start.
     *
     * @param port the port
     */
    public void start(int port);

    /**
     * Stop.
     */
    public void stop();

    /**
     * Send message.
     *
     * @param message the message
     */
    public void sendMessage(T message);

    /**
     * Read message.
     */
    public void readMessage();
}
