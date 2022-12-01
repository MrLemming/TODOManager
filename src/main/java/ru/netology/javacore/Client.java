package ru.netology.javacore;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8989;

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            out.println("{ \"type\": \"ADD\", \"task\": \"Сходить в магазин\" }");
            System.out.println(in.readLine());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
