package com.slummanagement.controle;

import com.slummanagement.modelo.Favela;
import com.slummanagement.modelo.Simulador;
import com.slummanagement.visao.DashboardPanel;
import com.slummanagement.visao.LojaPanel;
import com.slummanagement.visao.PersonalizacaoPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JogoController {
    private JFrame frame;
    private DashboardPanel dashboardPanel;
    private PersonalizacaoPanel personalizacaoPanel;
    private Simulador simulador;
    

    public JogoController(JFrame frame, PersonalizacaoPanel personalizacaoPanel, Simulador simulador, DashboardPanel dashboardPanel) {
        this.frame = frame;
        this.dashboardPanel = dashboardPanel;
        this.personalizacaoPanel = personalizacaoPanel;
        this.simulador = simulador;
    }

    public void inicializar() {
        personalizacaoPanel.getBotaoJogar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeJogador = personalizacaoPanel.getCampoNomeJogador().getText().trim();
                String nomeFavela = personalizacaoPanel.getCampoNomeFavela().getText().trim();

                if (nomeJogador.isEmpty() || nomeFavela.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos!");
                    return;
                }

                Favela favela = new Favela(nomeJogador, nomeFavela);
                simulador.iniciarJogo(favela);
                
                // Conecta o simulador ao dashboard para exibir mensagens
                simulador.setDashboardPanel(dashboardPanel);


                dashboardPanel.getLabelNomeJogador().setText("Nome: " + nomeJogador);
                dashboardPanel.getLabelNomeFavela().setText("Nome da Favela: " + nomeFavela);
                
                // Atualiza todas as informações do dashboard
                dashboardPanel.atualizarDashboard(favela);


                frame.setContentPane(dashboardPanel);
                frame.revalidate();
                frame.repaint(); 
                

                dashboardPanel.getBotaoLoja().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LojaPanel lojaPanel = new LojaPanel(favela, frame, dashboardPanel);

                        frame.setContentPane(lojaPanel);
                        frame.revalidate();
                        frame.repaint();
                    }
                });
            }
        });
    }
}