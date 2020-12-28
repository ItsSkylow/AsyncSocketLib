package fr.itssky.asyncsocketlib.server.sync;

import fr.itssky.asyncsocketlib.exception.HostException;
import fr.itssky.asyncsocketlib.server.handler.IHostHandler;
import fr.itssky.asyncsocketlib.server.IHost;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The type Host.
 *
 * @author ItsSky on 23/12/2020
 * @project AsyncSocketLib
 */
public class Host implements IHost<String> {
    // Network
    private ServerSocket server;
    private Socket socket;

    // Flux
    private PrintWriter out;
    private BufferedReader in;

    // Infos
    private final IHostHandler<String> handler;
    private final int port;

    /**
     * Instantiates a new Host.
     *
     * @param port    the port
     * @param handler the handler
     */
    public Host(int port, IHostHandler<String> handler) {
        this.port = port;
        this.handler = handler;

        // Initialize the server socket
        try {
            this.server = new ServerSocket(this.port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start() {
        try {
            // Wait client
            this.socket = server.accept();
            // Initialisation of flux (in & out)
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Notify handler that host is start
            this.handler.didStart();
        } catch (IOException e) {
            // Notify handler if something goes wrong
            this.handler.didStop(new HostException(e.getMessage()));
        }
    }

    @Override
    public void stop() {
        try {
            // Close all sockets & flux
            this.server.close();
            this.socket.close();
            this.in.close();
            this.out.close();
            // Notify handler that server is properly closed
            this.handler.didStop(new HostException("Server was properly close by the host"));
        } catch (IOException e) {
            // Notify handler if something goes wrong
            this.handler.didStop(new HostException(e.getMessage()));
        }
    }

    @Override
    public void sendMessage(String message) {
        // Send data
        this.out.println(message);
        this.out.flush();
        // Notify handler that all goes perfectly
        this.handler.didSendData(message);
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

    @Override
    public String getIp() {
        return this.server.getInetAddress().getHostAddress();
    }

    /**
     * Gets port.
     *
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * Gets handler.
     *
     * @return the handler
     */
    public IHostHandler<String> getHandler() {
        return handler;
    }
}
