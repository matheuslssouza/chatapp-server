package com;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

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
            System.out.println("Server Listening on Ip address: " + inetAddress.getHostAddress() + ":" + this.port);

            //Conditional for verify if the server is closed
            while(!serverSocket.isClosed()) {

                //If not closed, accept the connection for the socket
                Socket clientSocket = serverSocket.accept();

                System.out.println("Client Connected");

                // Get information about the connection
                InetAddress clientInetAddress = clientSocket.getInetAddress();
                System.out.println("Client IP Address: " + clientInetAddress.getHostAddress() + ":" + this.port);

                // Create Thread for every connection
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }

        } catch (Exception e) {
        }
        ;
    }
}
