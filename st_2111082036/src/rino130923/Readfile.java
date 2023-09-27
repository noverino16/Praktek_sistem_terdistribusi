/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rino130923;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author ASUS
 */
public class Readfile {
    public static void main(String args[]) throws IOException{
        System.out.println("What isthe name of the file to read from?");
        String filename ;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        filename = br.readLine();
        System.out.println("Now reading from "+ filename +"...");
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(filename);
        }catch(FileNotFoundException ex){
            System.out.println("File Not Found");
    }
        try{
            char data;
            int temp;
            do{
                temp = fis.read();
                data = (char) temp;
                if (temp!= -1){
                    System.out.println(data);
                    System.out.println(temp);
                }
            }while (temp != -1);
        }catch(IOException ex){
            System.out.println("Problem in reading from the file");
        }
    }
}
