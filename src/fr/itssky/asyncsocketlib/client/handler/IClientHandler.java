package fr.itssky.asyncsocketlib.client.handler;

import fr.itssky.asyncsocketlib.exception.ClientException;
import fr.itssky.asyncsocketlib.exception.NullDataException;

/**
 * The interface client handler.
 *
 * @param <T> the type parameter
 * @author ItsSky on 23/12/2020
 * @project AsyncSocketLib
 */
public interface IClientHandler<T> {
    /**
     * Notify Connection
     */
    void didConnect();

    /**
     * Notify disconnection
     *
     * @param error (can be null)
     */
    void didDisconnect(ClientException error);

    /**
     * Is start boolean.
     *
     * @return the boolean
     */
    boolean isConnect();

    /**
     * Notify data Reception
     *
     * @param data the data
     */
    void didReceiveData(T data);

    /**
     * Notify data Reception
     *
     * @param data the data
     */
    void didSendData(T data);

    /**
     * Gets exception.
     *
     * @return the exception throw by the client
     */
    Exception getException();

    /**
     * Gets data.
     *
     * @return the data
     * @throws NullDataException the null data exception
     */
    T getData() throws NullDataException;
}
