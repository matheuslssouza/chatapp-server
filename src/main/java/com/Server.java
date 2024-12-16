package com;
import java.net.InetAddress;
import java.net.ServerSocket;

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
            InetAddress inetAddress = serverSocket.getInetAddress();
            System.out.println("Ip address: " + inetAddress.getHostAddress() + ":" + this.port);

            //Conditional for verify if the server is closed
            while(!serverSocket.isClosed()) {
                //If not closed, accept the connection for the socket
                serverSocket.accept();
                System.out.println("Client Connected");
            }

        } catch (Exception e) {
        }
        ;
    }
}
