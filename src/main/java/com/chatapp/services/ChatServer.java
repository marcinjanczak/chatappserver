package com.chatapp.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private static final int PORT = 12345;
    private static List<PrintWriter> clientWriters = new ArrayList<>();


    public ChatServer(){

    }
    public static void run(){
        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Server został uruchomiony na porcie: " + PORT);

            while (true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nowy klient podłączony: "+ clientSocket.getInetAddress());

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            }

        }catch (IOException e){
            System.err.println("Błąd inicjalizacji servera." + e.getMessage());
        }
    }
    public static synchronized void broadcastMessage(String message) {
        for (PrintWriter writer : clientWriters) {
            writer.println(message);
        }
    }

    // Metoda do dodawania nowego klienta do listy
    public static synchronized void addClient(PrintWriter writer) {
        clientWriters.add(writer);
    }

    // Metoda do usuwania klienta z listy
    public static synchronized void removeClient(PrintWriter writer) {
        clientWriters.remove(writer);
    }
}

