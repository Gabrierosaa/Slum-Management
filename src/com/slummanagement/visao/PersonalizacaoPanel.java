package com.slummanagement.visao;

import javax.swing.*;
import java.awt.*;
import java.io.File; // Para verificar se o arquivo existe

public class PersonalizacaoPanel extends JPanel {

    private final String CAMINHO_IMAGEM_FUNDO = "res/imagens/favela.jpg"; 
    private Image imagemFundo;

    private JTextField campoNomeJogador;
    private JTextField campoNomeFavela;
    private JButton botaoJogar;

    public PersonalizacaoPanel() {
        // Tenta carregar a imagem de fundo
        try {
            // Verifica se o arquivo existe. Isso é importante para depuração!
            File imagemFile = new File("/res/imagens/favela.jpg");
            if (!imagemFile.exists()) {
                System.err.println("ERRO: Imagem de fundo não encontrada em: " + CAMINHO_IMAGEM_FUNDO);
            }
            // Usa ImageIcon para carregar a imagem e depois obter a Image
            imagemFundo = new ImageIcon(CAMINHO_IMAGEM_FUNDO).getImage();
        } catch (Exception e) {
            System.err.println("Erro ao carregar imagem de fundo: " + e.getMessage());
            e.printStackTrace();
        }

        setLayout(new GridBagLayout()); // Usar GridBagLayout para posicionamento flexível
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre componentes

        // 1. Título do Jogo (Arial)
        JLabel tituloJogo = new JLabel("SLUM MANAGEMENT");
        tituloJogo.setFont(new Font("Arial", Font.BOLD, 48)); // Fonte Arial, negrito, tamanho 48
        tituloJogo.setForeground(Color.WHITE); // Cor do texto
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa duas colunas
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza
        add(tituloJogo, gbc);

        // 2. Campo Nome do Jogador
        JLabel labelNomeJogador = new JLabel("Nome do Jogador:");
        labelNomeJogador.setFont(new Font("Arial", Font.PLAIN, 18));
        labelNomeJogador.setForeground(Color.WHITE);
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST; // Alinha à direita
        add(labelNomeJogador, gbc);

        campoNomeJogador = new JTextField(20); // 20 colunas de largura
        campoNomeJogador.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST; // Alinha à esquerda
        add(campoNomeJogador, gbc);

        // 3. Campo Nome da Favela
        JLabel labelNomeFavela = new JLabel("Nome da Favela:");
        labelNomeFavela.setFont(new Font("Arial", Font.PLAIN, 18));
        labelNomeFavela.setForeground(Color.WHITE);
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

        // 4. Botão Jogar
        botaoJogar = new JButton("JOGAR");
        botaoJogar.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(botaoJogar, gbc);

        // Adicionar o ActionListener ao botão (será implementado no Controlador)
        // botaoJogar.addActionListener(e -> { /* Lógica de iniciar o jogo */ });
    }

    // Este método é essencial para desenhar a imagem de fundo no painel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagemFundo != null) {
            // Desenha a imagem para preencher todo o painel
            g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);
        } else {
            // Se a imagem não carregou, desenha um fundo escuro
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    // Getters para os campos e o botão (para o Controlador acessar)
    public JTextField getCampoNomeJogador() { return campoNomeJogador; }
    public JTextField getCampoNomeFavela() { return campoNomeFavela; }
    public JButton getBotaoJogar() { return botaoJogar; }
}