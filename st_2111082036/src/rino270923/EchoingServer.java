package rino270923;

import java.io.*;
import java.net.*;

public class EchoingServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Listening...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                InputStream clientIn = clientSocket.getInputStream();
                OutputStream clientOut = clientSocket.getOutputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));
                PrintWriter pw = new PrintWriter(clientOut, true);

                String clientMessage = br.readLine();
                System.out.println("Client message: " + clientMessage);

                br.close();
                pw.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
