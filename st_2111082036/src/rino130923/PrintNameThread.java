/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rino130923;

/**
 *
 * @author ASUS
 */
public class PrintNameThread extends Thread{ 
    PrintNameThread(String name){
    super(name);
    start();
    }
    public void run(){
    String name = getName();
    for(int i=0; i<100;i++){
        
    }
    }
}
