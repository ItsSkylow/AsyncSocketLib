package fr.itssky.asyncsocketlib.server.handler;

import fr.itssky.asyncsocketlib.exception.HostException;
import fr.itssky.asyncsocketlib.exception.NullDataException;

/**
 * The interface Host handler.
 *
 * @param <T> the type parameter
 * @author ItsSky on 23/12/2020
 * @project AsyncSocketLib
 */
public interface IHostHandler<T> {
    /**
     * Notify Connection
     */
    void didStart();

    /**
     * Notify disconnection
     *
     * @param error (can be null)
     */
    void didStop(HostException error);

    /**
     * Is start boolean.
     *
     * @return the boolean
     */
    boolean isStart();

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
