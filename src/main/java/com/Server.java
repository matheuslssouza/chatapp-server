package com;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Server {

    // Socket Configs
    private ServerSocket serverSocket;
    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void startServer() {

        try {

            this.serverSocket = new ServerSocket(port);

            //Conditional for verify if the server is closed
            while(!serverSocket.isClosed()) {
                //If not closed, accept the connection for the socket
                serverSocket.accept();

            }

        } catch (Exception e) {
        }
        ;
    }
}
