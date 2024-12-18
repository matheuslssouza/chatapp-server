package com;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    private String clientName;

    ClientHandler(Socket clientSocket) {
        try {
            this.clientSocket = clientSocket;
            // To open an input stream associate with client socket for read the data send by clients.
            this.bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // We use PrintWriter to simplify the process for send data without put the measure of bytes.
            this.printWriter= new PrintWriter(clientSocket.getOutputStream(), true);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        printWriter.println("Welcome to the Server! Type: 'exit' to quit");

        String clientMessage;

        while (true) {
            try {
                clientMessage = bufferedReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
}

