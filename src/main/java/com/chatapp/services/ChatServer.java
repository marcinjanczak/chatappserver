package com.chatapp.services;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Stack;

public class ChatServer {
    private static final int PORT = 12345;
    private static Stack<String> messagesStack = new Stack<>();

    public ChatServer() throws IOException {

        try(ServerSocket serverSocket = new ServerSocket(PORT);){
            System.out.println("Server został uruchomiony na porcie: " + PORT);

            while (true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nowy klient podłączony: "+ clientSocket.getInetAddress());

            }

        }catch (IOException e){
            System.err.println("Błąd inicjalizacji servera." + e.getMessage());
        }
    }

    public static synchronized void addMessage(String message){
        messagesStack.push(message);
    }
    public static synchronized String getMessage(){
        return messagesStack.isEmpty() ? null : messagesStack.pop();
    }
}

