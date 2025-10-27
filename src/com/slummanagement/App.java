package com.slummanagement;

import com.slummanagement.visao.PersonalizacaoPanel;
import com.slummanagement.visao.PrincipalFrame;
import javax.swing.SwingUtilities; // Importar para garantir que a UI é criada na EDT

public class App {
    public static void main(String[] args) {
        // SwingUtilities.invokeLater garante que a criação e manipulação da UI
        // ocorram na Event Dispatch Thread (EDT), que é a thread segura do Swing.
        SwingUtilities.invokeLater(() -> {
            PrincipalFrame frame = new PrincipalFrame();
            PersonalizacaoPanel personalizacaoPanel = new PersonalizacaoPanel();
            
            // Adiciona o painel de personalização à janela principal
            frame.setConteudoPanel(personalizacaoPanel);
            
            // Cria e inicializa o controlador para ativar o botão Jogar
            com.slummanagement.controle.JogoController controller = new com.slummanagement.controle.JogoController(frame, personalizacaoPanel);
            controller.inicializar();
        });
    }
}