package juego;

import java.awt.*;
import javax.swing.*;

public class Juego {

    private static void createWindow() {
        
        // Se crea la ventana
        JFrame frame = new JFrame("Jueguito random");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel HPEnem = new JLabel("HP de enemigo", SwingConstants.CENTER);
        HPEnem.setPreferredSize(new Dimension(300,100));
        
        frame.getContentPane().add(HPEnem, BorderLayout.CENTER);
        
        frame.setLocationRelativeTo(null);
        
        frame.pack();
        
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        createWindow();
    }
}
