package fr.itssky.asyncsocketlib.server.handler;

import fr.itssky.asyncsocketlib.exception.HostException;
import fr.itssky.asyncsocketlib.exception.NullDataException;

/**
 * The type Host handler.
 *
 * @author ItsSky on 23/12/2020
 * @project AsyncSocketLib
 */
public class HostHandler implements IHostHandler<String> {
    private HostException exception;
    private boolean isStart;
    private String data;

    /**
     * Instantiates a new Host handler.
     */
    public HostHandler() {
        this.isStart = false;
        this.exception = null;
    }

    @Override
    public void didStart() {
        this.isStart = true;
    }

    @Override
    public void didStop(HostException error) {
        this.isStart = false;
        this.exception = error;
    }

    @Override
    public boolean isStart()  {
        return isStart;
    }

    @Override
    public void didReceiveData(String data) {
        this.data = data;
    }

    @Override
    public void didSendData(String data) {
        this.data = data;
    }

    @Override
    public Exception getException() {
        return this.exception;
    }

    @Override
    public String getData() throws NullDataException {
        try {
            Thread.sleep(1);
            return data;
        } catch (InterruptedException e) {
            throw new NullDataException();
        }
    }

}
