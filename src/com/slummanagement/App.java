package com.slummanagement;
import com.slummanagement.visao.PrincipalFrame;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
            new PrincipalFrame().setVisible(true)); 
    }
}
        
                