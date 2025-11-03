//Faz a ponte entre o Simulador.java e a Interface

package com.slummanagement.controle;

import com.slummanagement.modelo.Favela;
import com.slummanagement.modelo.Simulador;
import com.slummanagement.visao.PersonalizacaoPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JogoController {
    private JFrame frame;
    private PersonalizacaoPanel personalizacaoPanel;
    private Simulador simulador;
    

    public JogoController(JFrame frame, PersonalizacaoPanel personalizacaoPanel, Simulador simulador) {
        this.frame = frame;
        this.personalizacaoPanel = personalizacaoPanel;
        this.simulador = simulador;
    }

    public void inicializar(){
        personalizacaoPanel.getBotaoJogar().addActionListener(new ActionListener(){
             @Override
            public void actionPerformed(ActionEvent e) {
                String nomeJogador = personalizacaoPanel.getCampoNomeJogador().getText();
                String nomeFavela = personalizacaoPanel.getCampoNomeFavela().getText();
                Favela favela = new Favela(nomeJogador, nomeFavela);

                if (nomeJogador.isEmpty() || nomeFavela.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos!");
                }
                
                simulador.iniciarJogo(favela);

                PersonalizacaoPanel personalizacaoPanel = new PersonalizacaoPanel(simulador.getMensagemBoasVindas());
                frame.setContentPane(personalizacaoPanel);
                frame.revalidate();
                frame.repaint();

            }
        });
    }
}
