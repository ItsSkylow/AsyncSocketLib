package fr.itssky.asyncsocketlib.exception;

/**
 * The type Host exception.
 *
 * @author ItsSky on 23/12/2020
 * @project AsyncSocketLib
 */
public class HostException extends Exception {
    /**
     * Default error message
     */
    private static final String ERROR_MESSAGE = "An error occurred when attempt to host a server";

    /**
     * Constructor which use custom error message
     *
     * @param error the error
     */
    public HostException(String error) {
        super(error);
    }

    /**
     * Constructor which use default message
     */
    public HostException() {
        this(ERROR_MESSAGE);
    }
}
