package com.slummanagement.visao;

import javax.swing.JFrame;
import java.awt.Dimension;

public class PrincipalFrame extends JFrame{

    public PrincipalFrame() {
        setTitle("Slum Management - Jogo");
        setSize(new Dimension(800, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void setConteudoPanel(javax.swing.JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
    
}
