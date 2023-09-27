/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rino130923;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
public class Latihan {
    public static void main(String [] args){
    JFrame frame = new JFrame("Banner App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Masukkan teks:");
        JTextField textField = new JTextField(20);
        JButton printButton = new JButton("Cetak");

        // Action listener untuk tombol cetak
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                JOptionPane.showMessageDialog(frame, "Teks yang Anda masukkan: " + text);
            }
        });

        panel.add(label);
        panel.add(textField);
        panel.add(printButton);
        frame.add(panel);
        frame.setVisible(true);

    }
}
