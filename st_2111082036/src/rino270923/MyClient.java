package rino270923;

import java.io.*;
import java.net.*;

public class MyClient {
    public static void main(String args[]) {
        try {
            Socket client = new Socket(InetAddress.getLocalHost(), 1234);
            InputStream clientIn = client.getInputStream();
            OutputStream clientOut = client.getOutputStream();
            PrintWriter pw = new PrintWriter(clientOut, true);
            BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("Type a message for the server (or type 'exit' to quit): ");
                String userInput = stdIn.readLine();
                if (userInput.equalsIgnoreCase("exit")) {
                    break; // Exit the loop if the user enters 'exit'
                }
                pw.println(userInput);
                System.out.println(br.readLine());
            }

            pw.close();
            br.close();
            client.close();
        } catch (ConnectException ce) {
            System.out.println("Cannot connect to the server.");
        } catch (IOException ie) {
            System.out.println("I/O Error.");
        }
    }
}
