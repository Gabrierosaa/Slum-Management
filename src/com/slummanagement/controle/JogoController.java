package com.slummanagement.controle;

import com.slummanagement.modelo.Favela;
import com.slummanagement.modelo.Simulador;
import com.slummanagement.visao.PersonalizacaoPanel;
import com.slummanagement.visao.PrincipalFrame;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JogoController {

    private final PrincipalFrame frame;
    private final PersonalizacaoPanel personalizacaoPanel;
    private Favela favela; // cria a favela aqui
    private Simulador simulador; // inicia com a favela

    // Construtor: Recebe a Visão
    public JogoController(PrincipalFrame frame, PersonalizacaoPanel personalizacaoPanel) {
        this.frame = frame;
        this.personalizacaoPanel = personalizacaoPanel;
    }

    // O ponto de entrada para ligar os eventos
    public void inicializar() {
        personalizacaoPanel.getBotaoJogar().addActionListener(new AcaoListener());
    }

    // Método de Negócio: Iniciar Novo Jogo

    public void iniciarNovoJogo(String nomeJogador, String nomeFavela) {
        this.favela = new Favela(nomeJogador, nomeFavela); //CRIAÇÃO DO MODELO (POO)
        
        this.simulador = new Simulador(this.favela); //CRIAÇÃO DO MOTOR DE TEMPO
        
        simulador.iniciarLoopTempo(); //INICIAR O LOOP DO JOGO
        
        System.out.println("DEBUG: Jogo iniciado com a Favela " + nomeFavela);
        
        // Exemplo: frame.setConteudoPanel(new DashboardPanel(this.favela));
    }
    
    // Getter para a Favela (útil para outras classes, como o Dashboard, acessarem)
    public Favela getFavela() {
        return favela;
    }
    
    // ... (Aqui virão os métodos de comprar item, fazer upgrade, etc.)
    // ...
    

    /**
     * CLASSE INTERNA: Manipula o evento de clique do botão 'Jogar'.
     */
    private class AcaoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            // 1. Obter dados da Visão
            String nomeJogador = personalizacaoPanel.getCampoNomeJogador().getText().trim();
            String nomeFavela = personalizacaoPanel.getCampoNomeFavela().getText().trim();

            // 2. Validação simples
            if (nomeJogador.isEmpty() || nomeFavela.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.", "Erro de Personalização", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 3. Chamar o Método de Negócio do Controlador
            iniciarNovoJogo(nomeJogador, nomeFavela);
        }
    }
}