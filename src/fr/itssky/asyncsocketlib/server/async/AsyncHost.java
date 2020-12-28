package fr.itssky.asyncsocketlib.server.async;

import fr.itssky.asyncsocketlib.exception.HostException;
import fr.itssky.asyncsocketlib.server.asynctasks.*;
import fr.itssky.asyncsocketlib.server.handler.IHostHandler;
import fr.itssky.asyncsocketlib.server.sync.Host;
import fr.itssky.asyncsocketlib.server.IHost;

/**
 * The type Async host.
 *
 * @author ItsSky on 23/12/2020
 * @project AsyncSocketLib
 */
public class AsyncHost implements IHost<String> {
    private final Host host;
    private Thread task;

    /**
     * Instantiates a new Async host.
     *
     * @param port    the port
     * @param handler the handler
     */
    public AsyncHost(int port, IHostHandler<String> handler) {
        this.host = new Host(port, handler);
    }

    @Override
    public void start() {
        this.task = new Thread(new AsyncHostStartTask<>(this.host));
        // Start the host
        this.task.start();
    }

    @Override
    public void stop() {
        try {
            // Wait end of task thread
            this.task.join();
            // Stop the host
            this.task = new Thread(new AsyncHostStopTask<>(this.host));
            this.task.start();
        } catch (InterruptedException e) {
            this.host.getHandler().didStop(new HostException(e.getMessage()));
        }
    }

    @Override
    public void sendMessage(String message) {
        // Wait end of task thread
        try {
            // Wait end of task thread
            this.task.join();
            // Send message
            this.task = new Thread(new AsyncHostSendTask<>(this.host, message));
            this.task.start();
        } catch (InterruptedException e) {
            this.host.getHandler().didSendData(null);
        }
    }

    @Override
    public void readMessage() {
        try {
            // Wait end of task thread
            this.task.join();
            // Read receive message
            this.task = new Thread(new AsyncHostReadTask<>(this.host));
            this.task.start();
        } catch (InterruptedException e) {
            this.host.getHandler().didReceiveData(null);
        }
    }

    @Override
    public String getIp() {
        return this.host.getIp();
    }
}
