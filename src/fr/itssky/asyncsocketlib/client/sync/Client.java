package fr.itssky.asyncsocketlib.client.sync;

import fr.itssky.asyncsocketlib.client.IClient;
import fr.itssky.asyncsocketlib.client.handler.IClientHandler;
import fr.itssky.asyncsocketlib.exception.ClientException;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * The type Client.
 *
 * @author ItsSky on 23/12/2020
 * @project AsyncSocketLib
 */
public class Client implements IClient<String> {
    // Network
    private Socket socket;

    // Flux
    private BufferedWriter out;
    private BufferedReader in;

    // Infos
    private final IClientHandler<String> handler;

    /**
     * Instantiates a new Host.
     *
     * @param handler the handler
     */
    public Client(IClientHandler<String> handler) {
        this.handler = handler;
    }

    @Override
    public void connect(int port, String ip, int timeout) {
        try {
            // set the socket & attempt to connect
            this.socket.connect(new InetSocketAddress(ip, port), timeout);
            // Initialisation of flux (in & out)
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Notify handler that client is connect
            this.handler.didConnect();
        } catch (IOException e) {
            this.handler.didDisconnect(new ClientException(e.getMessage()));
        }
    }

    @Override
    public void disconnect() {
        try {
            // Close all sockets & flux
            if(this.socket.isConnected()) {
                this.socket.close();
                this.in.close();
                this.out.close();
            }
            // Notify handler that socket is properly closed
            this.handler.didDisconnect(new ClientException("Socket was close properly"));
        } catch (IOException e) {
            // Notify handler if something goes wrong
            this.handler.didDisconnect(new ClientException(e.getMessage()));
        }
    }

    @Override
    public void sendMessage(String message) {
        try {
            // Send data
            this.out.write(message);
            // Notify handler that all goes perfectly
            this.handler.didSendData(message);
        } catch (IOException e) {
            // Notify handler that something goes wrong
            this.handler.didSendData(null);
        }
    }

    @Override
    public void readMessage() {
        try {
            // Read data
            String data = this.in.readLine();
            // Notify handler that all goes perfectly
            this.handler.didReceiveData(data);
        } catch (IOException e) {
            // Notify handler that something goes wrong
            this.handler.didSendData(null);
        }
    }

    /**
     * Gets handler.
     *
     * @return the handler
     */
    public IClientHandler<String> getHandler() {
        return handler;
    }
}
