package com.slummanagement.visao;

import com.slummanagement.modelo.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class LojaPanel extends JPanel {
    private Favela favela;
    private JLabel labelSaldo;
    private JLabel labelMercadorias;
    private JFrame parentFrame;
    
    // Botões para integrantes
    private JButton btnComprarFabricante;
    private JButton btnComprarVendedor;
    private JButton btnComprarSeguranca;
    
    // Botões para melhorias
    private JButton btnMelhoriaNivel1;
    private JButton btnMelhoriaNivel2;
    private JButton btnMelhoriaNivel3;
    
    // Botão para comprar mercadorias
    private JButton btnComprarMercadorias;
    
    // Botão voltar
    private JButton btnVoltar;
    
    public LojaPanel(Favela favela, JFrame parentFrame) {
        this.favela = favela;
        this.parentFrame = parentFrame;
        initializeComponents();
        setupLayout();
        setupEventListeners();
        atualizarInformacoes();
    }
    
    private void initializeComponents() {
        setBackground(new Color(45, 45, 45));
        setLayout(new BorderLayout());
        
        // Labels de informação
        labelSaldo = new JLabel();
        labelMercadorias = new JLabel();
        
        // Botões de integrantes
        btnComprarFabricante = criarBotaoItem("Contratar Fabricante", "Produz mercadorias automaticamente", 100.0);
        btnComprarVendedor = criarBotaoItem("Contratar Vendedor", "Aumenta lucro das vendas", 150.0);
        btnComprarSeguranca = criarBotaoItem("Contratar Segurança", "Protege a favela de ataques", 200.0);
        
        // Botões de melhorias
        btnMelhoriaNivel1 = criarBotaoItem("Melhoria Nível 1", "Pequena melhoria na favela", 
                Melhoria.NivelUpgrade.NIVEL1.getMelhoriaPreco());
        btnMelhoriaNivel2 = criarBotaoItem("Melhoria Nível 2", "Melhoria média na favela", 
                Melhoria.NivelUpgrade.NIVEL2.getMelhoriaPreco());
        btnMelhoriaNivel3 = criarBotaoItem("Melhoria Nível 3", "Grande melhoria na favela", 
                Melhoria.NivelUpgrade.NIVEL3.getMelhoriaPreco());
        
        // Botão para comprar mercadorias
        btnComprarMercadorias = criarBotaoItem("Comprar Mercadorias (x10)", "Adiciona 10 mercadorias ao estoque", 20.0);
        
        // Botão voltar
        btnVoltar = new JButton("← Voltar");
        btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
        btnVoltar.setBackground(new Color(150, 150, 150));
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.setPreferredSize(new Dimension(120, 40));
    }
    
    private JButton criarBotaoItem(String nome, String descricao, double preco) {
        JButton botao = new JButton();
        botao.setLayout(new BorderLayout());
        botao.setBackground(new Color(70, 130, 180));
        botao.setForeground(Color.WHITE);
        botao.setBorderPainted(false);
        botao.setFocusPainted(false);
        botao.setPreferredSize(new Dimension(250, 80));
        
        JLabel labelNome = new JLabel(nome);
        labelNome.setFont(new Font("Arial", Font.BOLD, 14));
        labelNome.setForeground(Color.WHITE);
        labelNome.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel labelDescricao = new JLabel(descricao);
        labelDescricao.setFont(new Font("Arial", Font.PLAIN, 11));
        labelDescricao.setForeground(Color.LIGHT_GRAY);
        labelDescricao.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel labelPreco = new JLabel("R$ " + String.format("%.2f", preco));
        labelPreco.setFont(new Font("Arial", Font.BOLD, 12));
        labelPreco.setForeground(Color.YELLOW);
        labelPreco.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel infoPanel = new JPanel(new GridLayout(3, 1));
        infoPanel.setOpaque(false);
        infoPanel.add(labelNome);
        infoPanel.add(labelDescricao);
        infoPanel.add(labelPreco);
        
        botao.add(infoPanel, BorderLayout.CENTER);
        
        return botao;
    }
    
    private void setupLayout() {
        // Painel superior com informações
        JPanel painelInfo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelInfo.setBackground(new Color(35, 35, 35));
        painelInfo.setBorder(new EmptyBorder(15, 20, 15, 20));
        
        JLabel titulo = new JLabel("🏪 LOJA DA FAVELA");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        
        labelSaldo.setFont(new Font("Arial", Font.BOLD, 16));
        labelSaldo.setForeground(Color.GREEN);
        
        labelMercadorias.setFont(new Font("Arial", Font.BOLD, 16));
        labelMercadorias.setForeground(Color.CYAN);
        
        painelInfo.add(titulo);
        painelInfo.add(Box.createHorizontalStrut(50));
        painelInfo.add(labelSaldo);
        painelInfo.add(Box.createHorizontalStrut(30));
        painelInfo.add(labelMercadorias);
        
        // Painel central com itens da loja
        JPanel painelCentral = new JPanel(new GridLayout(2, 1, 10, 10));
        painelCentral.setBackground(new Color(45, 45, 45));
        painelCentral.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        // Seção de integrantes
        JPanel secaoIntegrantes = criarSecao("👥 CONTRATAR INTEGRANTES", 
                new JButton[]{btnComprarFabricante, btnComprarVendedor, btnComprarSeguranca});
        
        // Painel para melhorias e mercadorias
        JPanel painelMelhoriasMercadorias = new JPanel(new GridLayout(1, 2, 10, 0));
        painelMelhoriasMercadorias.setOpaque(false);
        
        JPanel secaoMelhorias = criarSecao("🏗️ MELHORIAS", 
                new JButton[]{btnMelhoriaNivel1, btnMelhoriaNivel2, btnMelhoriaNivel3});
        
        JPanel secaoMercadorias = criarSecao("📦 MERCADORIAS", 
                new JButton[]{btnComprarMercadorias});
        
        painelMelhoriasMercadorias.add(secaoMelhorias);
        painelMelhoriasMercadorias.add(secaoMercadorias);
        
        painelCentral.add(secaoIntegrantes);
        painelCentral.add(painelMelhoriasMercadorias);
        
        // Painel inferior com botão voltar
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelInferior.setBackground(new Color(45, 45, 45));
        painelInferior.setBorder(new EmptyBorder(10, 20, 20, 20));
        painelInferior.add(btnVoltar);
        
        // Adicionar ao painel principal
        add(painelInfo, BorderLayout.NORTH);
        add(painelCentral, BorderLayout.CENTER);
        add(painelInferior, BorderLayout.SOUTH);
    }
    
    private JPanel criarSecao(String titulo, JButton[] botoes) {
        JPanel secao = new JPanel(new BorderLayout());
        secao.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY), 
                titulo, 
                TitledBorder.LEFT, 
                TitledBorder.TOP, 
                new Font("Arial", Font.BOLD, 14), 
                Color.WHITE));
        secao.setBackground(new Color(55, 55, 55));
        
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        painelBotoes.setBackground(new Color(55, 55, 55));
        
        for (JButton botao : botoes) {
            painelBotoes.add(botao);
        }
        
        secao.add(painelBotoes, BorderLayout.CENTER);
        return secao;
    }
    
    private void setupEventListeners() {
        btnComprarFabricante.addActionListener(e -> comprarIntegrante("Fabricante", 100.0));
        btnComprarVendedor.addActionListener(e -> comprarIntegrante("Vendedor", 150.0));
        btnComprarSeguranca.addActionListener(e -> comprarIntegrante("Seguranca", 200.0));
        
        btnMelhoriaNivel1.addActionListener(e -> comprarMelhoria(Melhoria.NivelUpgrade.NIVEL1));
        btnMelhoriaNivel2.addActionListener(e -> comprarMelhoria(Melhoria.NivelUpgrade.NIVEL2));
        btnMelhoriaNivel3.addActionListener(e -> comprarMelhoria(Melhoria.NivelUpgrade.NIVEL3));
        
        btnComprarMercadorias.addActionListener(e -> comprarMercadorias());
        
        btnVoltar.addActionListener(e -> voltarMenu());
    }
    
    private void comprarIntegrante(String tipo, double preco) {
        if (favela.getSaldoDinheiro() >= preco) {
            if (favela.gastarDinheiro(preco)) {
                Integrante novoIntegrante = null;
                
                switch (tipo) {
                    case "Fabricante":
                        novoIntegrante = new Fabricante("Fabricante #" + (favela.getIntegrantes().size() + 1));
                        break;
                    case "Vendedor":
                        novoIntegrante = new Vendedor("Vendedor #" + (favela.getIntegrantes().size() + 1));
                        break;
                    case "Seguranca":
                        novoIntegrante = new Seguranca("Segurança #" + (favela.getIntegrantes().size() + 1));
                        break;
                }
                
                if (novoIntegrante != null) {
                    favela.adicionarIntegrante(novoIntegrante);
                    mostrarMensagem("Sucesso!", tipo + " contratado com sucesso!");
                    atualizarInformacoes();
                }
            }
        } else {
            mostrarMensagem("Erro!", "Saldo insuficiente para contratar " + tipo + "!");
        }
    }
    
    private void comprarMelhoria(Melhoria.NivelUpgrade nivelUpgrade) {
        double preco = nivelUpgrade.getMelhoriaPreco();
        
        if (favela.getSaldoDinheiro() >= preco) {
            if (favela.gastarDinheiro(preco)) {
                // Aqui você poderia aplicar os efeitos da melhoria na favela
                mostrarMensagem("Sucesso!", "Melhoria Nível " + nivelUpgrade.getNivel() + " adquirida!");
                atualizarInformacoes();
            }
        } else {
            mostrarMensagem("Erro!", "Saldo insuficiente para esta melhoria!");
        }
    }
    
    private void comprarMercadorias() {
        double preco = 20.0;
        
        if (favela.getSaldoDinheiro() >= preco) {
            if (favela.gastarDinheiro(preco)) {
                favela.adicionarMercadoria(10);
                mostrarMensagem("Sucesso!", "10 mercadorias adicionadas ao estoque!");
                atualizarInformacoes();
            }
        } else {
            mostrarMensagem("Erro!", "Saldo insuficiente para comprar mercadorias!");
        }
    }
    
    private void voltarMenu() {
        // Aqui você poderia implementar a lógica para voltar ao menu principal
        if (parentFrame != null) {
            parentFrame.dispose();
        }
    }
    
    private void atualizarInformacoes() {
        labelSaldo.setText("💰 Saldo: R$ " + String.format("%.2f", favela.getSaldoDinheiro()));
        labelMercadorias.setText("📦 Mercadorias: " + favela.getMercadoriaTotal());
        
        // Atualizar disponibilidade dos botões baseada no saldo
        atualizarDisponibilidadeBotoes();
    }
    
    private void atualizarDisponibilidadeBotoes() {
        double saldo = favela.getSaldoDinheiro();
        
        btnComprarFabricante.setEnabled(saldo >= 100.0);
        btnComprarVendedor.setEnabled(saldo >= 150.0);
        btnComprarSeguranca.setEnabled(saldo >= 200.0);
        
        btnMelhoriaNivel1.setEnabled(saldo >= Melhoria.NivelUpgrade.NIVEL1.getMelhoriaPreco());
        btnMelhoriaNivel2.setEnabled(saldo >= Melhoria.NivelUpgrade.NIVEL2.getMelhoriaPreco());
        btnMelhoriaNivel3.setEnabled(saldo >= Melhoria.NivelUpgrade.NIVEL3.getMelhoriaPreco());
        
        btnComprarMercadorias.setEnabled(saldo >= 20.0);
    }
    
    private void mostrarMensagem(String titulo, String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, titulo, 
                titulo.equals("Sucesso!") ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
    }
    
    public void setConteudoPanel(javax.swing.JPanel panel) {
        removeAll();
        add(panel);
        revalidate();
        repaint();
    }
}
