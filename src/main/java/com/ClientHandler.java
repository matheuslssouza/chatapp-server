package com;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket;

    ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        try {
            InputStream input = clientSocket.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            OutputStream output = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println("Welcome to Server!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Message sent to client.");
    }
}
