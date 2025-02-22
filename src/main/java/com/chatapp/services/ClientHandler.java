package com.chatapp.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;
    public ClientHandler(Socket socket){
        this.clientSocket = socket;
    }
    @Override
    public void run(){
        try{
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            ChatServer.addClient(out);

            String inputLine;
            while ((inputLine = in.readLine()) != null){
                System.out.println("Otrzymano wiadomość: " + inputLine);
                ChatServer.broadcastMessage(inputLine);

//                out.println(clientSocket.getInetAddress() + " " + inputLine);
            }
            ChatServer.removeClient(out);

            in.close();
            out.close();
            clientSocket.close();
            System.out.println("Klient: " + clientSocket.getInetAddress() + " rozłączony.");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
