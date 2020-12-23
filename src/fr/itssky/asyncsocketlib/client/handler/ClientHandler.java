package fr.itssky.asyncsocketlib.client.handler;

import fr.itssky.asyncsocketlib.exception.ClientException;
import fr.itssky.asyncsocketlib.exception.NullDataException;

/**
 * The type Client handler.
 *
 * @author ItsSky on 23/12/2020
 * @project AsyncSocketLib
 */
public class ClientHandler implements IClientHandler<String> {
    private ClientException exception;
    private boolean isConnect;
    private String data;

    /**
     * Instantiates a new Host handler.
     */
    public ClientHandler() {
        this.isConnect = false;
        this.exception = null;
    }

    @Override
    public void didConnect() {
        this.isConnect = true;
    }

    @Override
    public void didDisconnect(ClientException error) {
        this.isConnect = false;
        this.exception = error;
    }

    @Override
    public boolean isConnect()  {
        return isConnect;
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
        if(data == null)
            throw new NullDataException();
        return data;
    }

}
