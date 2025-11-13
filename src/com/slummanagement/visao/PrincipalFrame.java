package com.slummanagement.visao;

import com.slummanagement.controle.JogoController;
import com.slummanagement.modelo.Simulador;
import java.awt.Dimension;
import javax.swing.JFrame;

public class PrincipalFrame extends JFrame{

    public PrincipalFrame() {
        setTitle("Slum Management - Jogo");
        setSize(new Dimension(1780, 1000));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        DashboardPanel dashboardPanel = new DashboardPanel();

        PersonalizacaoPanel personalizacaoPanel = new PersonalizacaoPanel();
        Simulador simulador = new Simulador();

        JogoController controller = new JogoController(this, personalizacaoPanel, simulador, dashboardPanel);
        controller.inicializar();

        setContentPane(personalizacaoPanel);
    
    }

    public void setConteudoPanel(javax.swing.JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
    
}
