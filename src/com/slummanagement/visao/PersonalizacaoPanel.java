package com.slummanagement.visao;

import java.awt.*;
import java.io.File;
import javax.swing.*; // Para verificar se o arquivo existe

public class PersonalizacaoPanel extends JPanel {

    private final String CAMINHO_IMAGEM_FUNDO = "res/imagens/favela.jpg"; 
    private Image imagemFundo;
    private JLabel labelMensagem;
    private JTextField campoNomeJogador;
    private JTextField campoNomeFavela;
    private JButton botaoJogar;

    public PersonalizacaoPanel() {
        try {
            File imagemFile = new File("/res/imagens/favela.jpg");
            if (!imagemFile.exists()) {
                System.err.println("ERRO: Imagem de fundo não encontrada em: " + CAMINHO_IMAGEM_FUNDO);
            }

            imagemFundo = new ImageIcon(CAMINHO_IMAGEM_FUNDO).getImage();
        } catch (Exception e) {
            System.err.println("Erro ao carregar imagem de fundo: " + e.getMessage());
            e.printStackTrace();
        }

        setLayout(new GridBagLayout()); // Usar GridBagLayout para posicionamento flexível
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Título do Jogo
        JLabel tituloJogo = new JLabel("SLUM MANAGEMENT");
        tituloJogo.setFont(new Font("Arial", Font.BOLD, 48));
        tituloJogo.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(tituloJogo, gbc);

        // Campo Nome do Jogador
        JLabel labelNomeJogador = new JLabel("Nome do Jogador:");
        labelNomeJogador.setFont(new Font("Arial", Font.PLAIN, 18));
        labelNomeJogador.setForeground(Color.BLACK);
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(labelNomeJogador, gbc);

        campoNomeJogador = new JTextField(20);
        campoNomeJogador.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(campoNomeJogador, gbc);

        // Campo Nome da Favela
        JLabel labelNomeFavela = new JLabel("Nome da Favela:");
        labelNomeFavela.setFont(new Font("Arial", Font.PLAIN, 18));
        labelNomeFavela.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(labelNomeFavela, gbc);

        campoNomeFavela = new JTextField(20);
        campoNomeFavela.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(campoNomeFavela, gbc);

        // Botão Jogar
        botaoJogar = new JButton("JOGAR");
        botaoJogar.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(botaoJogar, gbc);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagemFundo != null) {
            g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);
        } else {
            g.setColor(Color.ORANGE);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    public JTextField getCampoNomeJogador() { return campoNomeJogador; }
    public JTextField getCampoNomeFavela() { return campoNomeFavela; }
    public JButton getBotaoJogar() { return botaoJogar; }

    public PersonalizacaoPanel(String mensagem) {
        labelMensagem = new JLabel(mensagem);
        add(labelMensagem);
    }
}