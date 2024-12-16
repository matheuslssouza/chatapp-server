package com;

public class Main {
    public static void main(String[] args) {

        //create a websocket
    Server server = new Server(4000);
        //connect with database
        server.startServer();
    }
}