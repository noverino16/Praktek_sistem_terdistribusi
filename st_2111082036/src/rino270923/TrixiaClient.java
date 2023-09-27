/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rino270923;

/**
 *
 * @author ASUS
 */
import java.io.*;
import java.net.*;

public class TrixiaClient {
    public static void main(String args[]) {
        try {
            Socket client = new Socket(InetAddress.getLocalHost(), 1234);
            InputStream clientIn = client.getInputStream();
            OutputStream clientOut = client.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));
            PrintWriter pw = new PrintWriter(clientOut, true);
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                pw.println(userInput);
                String serverResponse = br.readLine();
                System.out.println("Server message: ");
                System.out.println(serverResponse);
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
