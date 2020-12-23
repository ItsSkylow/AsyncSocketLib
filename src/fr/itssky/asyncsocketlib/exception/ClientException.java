package fr.itssky.asyncsocketlib.exception;

/**
 * The type Client exception.
 *
 * @author ItsSky on 23/12/2020
 * @project AsyncSocketLib
 */
public class ClientException extends Exception {
    /**
     * Default error message
     */
    private static final String ERROR_MESSAGE = "An error occurred when attempt to connect to the socket";

    /**
     * Constructor which use custom error message
     *
     * @param error the error
     */
    public ClientException(String error) {
        super(error);
    }

    /**
     * Constructor which use default message
     */
    public ClientException() {
        this(ERROR_MESSAGE);
    }
}
