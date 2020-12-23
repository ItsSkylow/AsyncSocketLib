package fr.itssky.asyncsocketlib.exception;

/**
 * The type Null data exception.
 *
 * @author ItsSky on 23/12/2020
 * @project AsyncSocketLib
 */
public class NullDataException extends Exception {
    /**
     * Default error message
     */
    private static final String ERROR_MESSAGE = "Data are null or empty";

    /**
     * Constructor which use custom error message
     *
     * @param error the error
     */
    public NullDataException(String error) {
        super(error);
    }

    /**
     * Constructor which use default message
     */
    public NullDataException() {
        this(ERROR_MESSAGE);
    }
}
