package com.slummanagement.testes;

import com.slummanagement.modelo.Favela;
import com.slummanagement.visao.LojaPanel;
import javax.swing.JFrame;
import java.awt.Dimension;

public class TesteLojaPanel {
    public static void main(String[] args) {
        // Criar uma favela de teste
        Favela favela = new Favela("João", "Favela do João");
        
        // Criar e configurar a janela
        JFrame frame = new JFrame("Teste - Loja da Favela");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(800, 600));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        
        // Criar o painel da loja
        //LojaPanel lojaPanel = new LojaPanel(favela, frame);
        
        // Adicionar o painel à janela
        //frame.setContentPane(lojaPanel);
        
        // Mostrar a janela
        frame.setVisible(true);
        
        System.out.println("Loja aberta com:");
        System.out.println("Saldo inicial: R$ " + favela.getSaldoDinheiro());
        System.out.println("Mercadorias iniciais: " + favela.getMercadoriaTotal());
    }
}