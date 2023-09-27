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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class TrixiaServer {
    private static ArrayList<String> questions;
    private static HashMap<Integer, String> answers;

    public static void main(String[] args) {
        questions = new ArrayList<>();
        answers = new HashMap<>();

        // Menambahkan pertanyaan dan jawaban ke dalam koleksi
        questions.add("Apa ibukota Indonesia?");
        answers.put(1, "Jakarta");

        questions.add("Siapakah penemu bola lampu?");
        answers.put(2, "Thomas Edison");

        // Tambahkan pertanyaan dan jawaban lainnya di sini

        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Trivia Server is running on port 1234...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                InputStream clientIn = clientSocket.getInputStream();
                OutputStream clientOut = clientSocket.getOutputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));
                PrintWriter pw = new PrintWriter(clientOut, true);

                String clientMessage = br.readLine();
                if (clientMessage != null) {
                    if (clientMessage.equalsIgnoreCase("permintaan")) {
                        // Memilih pertanyaan secara acak
                        int randomIndex = new Random().nextInt(questions.size());
                        String randomQuestion = questions.get(randomIndex);
                        pw.println(randomQuestion);
                    } else if (clientMessage.startsWith("jawaban")) {
                        String[] parts = clientMessage.split("#");
                        if (parts.length == 2) {
                            int questionNumber = Integer.parseInt(parts[0].substring(7));
                            String userAnswer = parts[1];
                            String correctAnswer = answers.get(questionNumber);
                            if (correctAnswer != null) {
                                if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                                    pw.println("Jawaban Anda benar!");
                                } else {
                                    pw.println("Jawaban Anda salah. Jawaban yang benar adalah: " + correctAnswer);
                                }
                            } else {
                                pw.println("Nomor pertanyaan tidak valid.");
                            }
                        } else {
                            pw.println("Format jawaban tidak valid.");
                        }
                    }
                }

                br.close();
                pw.close();
                clientSocket.close();
                //System.out.println("Client disconnected.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
