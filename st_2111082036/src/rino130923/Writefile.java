/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rino130923;

/**
 *
 * @author ASUS
 */
import java.io.*;
public class Writefile {
    public static void main(String args[])throws IOException{
        System.out.println("What is the name of the file to be written to?");
        String filename;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        filename = br.readLine();
        System.out.println("Enter data to write to "+ filename +"...");
        System.out.println("Type qS to end");
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(filename);
        }catch(FileNotFoundException ex){
            System.out.println("File cannot be opened for writing. ");
        }
    }
}
