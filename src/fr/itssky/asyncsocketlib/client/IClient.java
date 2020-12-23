package fr.itssky.asyncsocketlib.client;

/**
 * The interface Client.
 *
 * @param <T> the type parameter
 * @author ItsSky on 23/12/2020
 * @project AsyncSocketLib
 */
public interface IClient<T> {
    /**
     * Connect.
     *
     * @param port    the port
     * @param ip      the ip
     * @param timeout the timeout
     */
    public void connect(int port, String ip, int timeout);

    /**
     * Disconnect.
     */
    public void disconnect();

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
