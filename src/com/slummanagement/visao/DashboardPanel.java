package com.slummanagement.visao;

import com.slummanagement.modelo.Favela;
import com.slummanagement.modelo.Integrante;
import com.slummanagement.modelo.Fabricante;
import com.slummanagement.modelo.Vendedor;
import com.slummanagement.modelo.Seguranca;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

public class DashboardPanel extends JPanel {

    private JLabel labelNomeJogador;
    private JLabel labelNomeFavela;
    private JLabel labelDinheiro;
    private JLabel labelNivel;

    private JLabel labelMercadoriaTotal;
    private JLabel labelFabricantes;
    private JLabel labelVendedores;
    private JLabel labelSegurancas;
    private JLabel labelInfluencers;

    private JTextArea areaMensagens;
    private JButton botaoLoja;

    private Image backgroundImage;

    public DashboardPanel() {
        // --- TENTA CARREGAR A IMAGEM DE FUNDO ---
        try {
            backgroundImage = ImageIO.read(getClass().getResource("res/imagens/favela.jpg"));
        } catch (IOException | IllegalArgumentException e) {
            backgroundImage = null;
        }

        setLayout(new GridBagLayout());
        setBackground(new Color(20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(40, 40, 40, 40);

        Font fonteTitulo = new Font("Segoe UI", Font.BOLD, 18);
        Font fontePadrao = new Font("Segoe UI", Font.PLAIN, 16);

        // ---------- PAINEL PRINCIPAL SEMI-TRANSPARENTE ----------
        JPanel painelPrincipal = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(new Color(0, 0, 0, 150));
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
                g2d.dispose();
            }
        };
        painelPrincipal.setOpaque(false);
        painelPrincipal.setBorder(new EmptyBorder(30, 40, 30, 40));

        GridBagConstraints gpc = new GridBagConstraints();
        gpc.insets = new Insets(20, 20, 20, 20);
        gpc.fill = GridBagConstraints.BOTH;

        // ---------- TOPO ----------
        JPanel painelTopo = new JPanel(new GridLayout(1, 4, 40, 0));
        painelTopo.setOpaque(false);
        painelTopo.setBorder(new EmptyBorder(10, 10, 30, 10));

        labelNomeJogador = new JLabel("Nome: ");
        labelNomeFavela = new JLabel("Favela: ");
        labelDinheiro = new JLabel("Dinheiro: ");
        labelNivel = new JLabel("Nível: ");

        JLabel[] topoLabels = { labelNomeJogador, labelNomeFavela, labelDinheiro, labelNivel };
        for (JLabel lbl : topoLabels) {
            lbl.setForeground(Color.WHITE);
            lbl.setFont(fonteTitulo);
            lbl.setHorizontalAlignment(SwingConstants.CENTER);
        }

        for (JLabel lbl : topoLabels) painelTopo.add(lbl);

        gpc.gridx = 0;
        gpc.gridy = 0;
        gpc.gridwidth = 3;
        gpc.weightx = 1;
        gpc.weighty = 0;
        painelPrincipal.add(painelTopo, gpc);

        // ---------- PAINEL INFERIOR (3 COLUNAS) ----------
        gpc.gridy = 1;
        gpc.gridwidth = 1;
        gpc.weighty = 1;

        // --- Painel ESQUERDA ---
        JPanel painelEsquerda = criarPainelInfo("Informações");
        painelEsquerda.setLayout(new GridLayout(5, 1, 10, 10));
        painelEsquerda.setBorder(BorderFactory.createCompoundBorder(
            painelEsquerda.getBorder(),
            new EmptyBorder(20, 25, 20, 25)
        ));

        labelMercadoriaTotal = new JLabel("Mercadoria total:");
        labelFabricantes = new JLabel("Fabricantes:");
        labelVendedores = new JLabel("Vendedores:");
        labelSegurancas = new JLabel("Seguranças:");
        labelInfluencers = new JLabel("Influencers:");

        for (JLabel lbl : new JLabel[]{labelMercadoriaTotal, labelFabricantes, labelVendedores, labelSegurancas, labelInfluencers}) {
            lbl.setForeground(Color.WHITE);
            lbl.setFont(fontePadrao);
        }

        painelEsquerda.add(labelMercadoriaTotal);
        painelEsquerda.add(labelFabricantes);
        painelEsquerda.add(labelVendedores);
        painelEsquerda.add(labelSegurancas);
        painelEsquerda.add(labelInfluencers);

        gpc.gridx = 0;
        gpc.insets = new Insets(0, 0, 0, 30);
        gpc.weightx = 0.3;
        painelPrincipal.add(painelEsquerda, gpc);

        // --- Painel CENTRO (LOJA) ---
        botaoLoja = new JButton("LOJA");
        botaoLoja.setFont(new Font("Segoe UI", Font.BOLD, 26));
        botaoLoja.setFocusPainted(false);
        botaoLoja.setBackground(new Color(80, 80, 80, 200));
        botaoLoja.setForeground(Color.WHITE);
        botaoLoja.setBorder(new LineBorder(Color.WHITE, 2, true));
        botaoLoja.setPreferredSize(new Dimension(220, 80));
        botaoLoja.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

         add(botaoLoja);

        JPanel painelCentro = new JPanel(new GridBagLayout());
        painelCentro.setOpaque(false);
        painelCentro.add(botaoLoja);
        painelCentro.setBorder(new EmptyBorder(20, 20, 20, 20));

        gpc.gridx = 1;
        gpc.insets = new Insets(0, 30, 0, 30);
        gpc.weightx = 0.4;
        painelPrincipal.add(painelCentro, gpc);

        // --- Painel DIREITA (Mensagens) ---
        JPanel painelDireita = criarPainelInfo("Logs de Eventos");
        painelDireita.setLayout(new BorderLayout(10, 10));
        painelDireita.setBorder(BorderFactory.createCompoundBorder(
            painelDireita.getBorder(),
            new EmptyBorder(15, 20, 15, 20)
        ));

        areaMensagens = new JTextArea();
        areaMensagens.setFont(new Font("Consolas", Font.PLAIN, 12));
        areaMensagens.setEditable(false);
        areaMensagens.setBackground(new Color(255, 255, 255, 20));
        areaMensagens.setForeground(Color.WHITE);
        areaMensagens.setLineWrap(true);
        areaMensagens.setWrapStyleWord(true);
        areaMensagens.setBorder(new EmptyBorder(10, 10, 10, 10));

        JScrollPane scroll = new JScrollPane(areaMensagens);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);
        painelDireita.add(scroll, BorderLayout.CENTER);

        gpc.gridx = 2;
        gpc.insets = new Insets(0, 30, 0, 0);
        gpc.weightx = 0.3;
        painelPrincipal.add(painelDireita, gpc);

        // ---------- Adiciona o painel principal ----------
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(painelPrincipal, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        } else {
            Graphics2D g2d = (Graphics2D) g;
            GradientPaint gp = new GradientPaint(0, 0, new Color(45, 45, 45), 0, getHeight(), new Color(20, 20, 20));
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    private JPanel criarPainelInfo(String titulo) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createTitledBorder(
            new LineBorder(Color.WHITE, 1, true),
            titulo,
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Segoe UI", Font.BOLD, 14),
            Color.WHITE
        ));
        panel.setPreferredSize(new Dimension(280, 260));
        return panel;
    }

    public void atualizarDashboard(Favela favela) {
        labelDinheiro.setText("Dinheiro: R$ " + String.format("%.2f", favela.getSaldoDinheiro()));
        labelMercadoriaTotal.setText("Mercadoria total: " + favela.getMercadoriaTotal());
        labelNivel.setText("Nível: " + favela.getNivel());
        
        // Contar cada tipo de integrante
        int numFabricantes = 0;
        int numVendedores = 0;
        int numSegurancas = 0;
        
        for (Integrante integrante : favela.getIntegrantes()) {
            if (integrante instanceof Fabricante) {
                numFabricantes++;
            } else if (integrante instanceof Vendedor) {
                numVendedores++;
            } else if (integrante instanceof Seguranca) {
                numSegurancas++;
            }
        }
        
        labelFabricantes.setText("Fabricantes: " + numFabricantes);
        labelVendedores.setText("Vendedores: " + numVendedores);
        labelSegurancas.setText("Seguranças: " + numSegurancas);
        labelInfluencers.setText("Influencers: " + favela.getInfluencers().size());
    }

    public JLabel getLabelNomeJogador() { return labelNomeJogador; }
    public JLabel getLabelNomeFavela() { return labelNomeFavela; }
    public JLabel getLabelDinheiro() { return labelDinheiro; }
    public JLabel getLabelNivel() { return labelNivel; }

    public JLabel getLabelMercadoriaTotal() { return labelMercadoriaTotal; }
    public JLabel getLabelFabricantes() { return labelFabricantes; }
    public JLabel getLabelVendedores() { return labelVendedores; }
    public JLabel getLabelSegurancas() { return labelSegurancas; }
    public JLabel getLabelInfluencers() { return labelInfluencers; }

    public JTextArea getAreaMensagens() { return areaMensagens; }
    
    public JButton getBotaoLoja() { return botaoLoja; }
    
    /**
     * Adiciona uma mensagem na área de mensagens com timestamp
     */
    public void adicionarMensagem(String mensagem) {
        String textoAtual = areaMensagens.getText();
        String novaLinha = textoAtual.isEmpty() ? "" : "\n";
        
        // Adiciona timestamp simples
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss");
        String timestamp = sdf.format(new java.util.Date());
        
        areaMensagens.append(novaLinha + "[" + timestamp + "] " + mensagem);
        
        // Auto-scroll para o final
        areaMensagens.setCaretPosition(areaMensagens.getDocument().getLength());
    }
}