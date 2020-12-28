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
     */
    public void start();

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

    /**
     * Gets ip.
     *
     * @return the ip
     */
    public String getIp();
}
