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
    
    // Botões para integrantes - Fabricante
    private JButton btnComprarFabricanteN1;
    private JButton btnComprarFabricanteN2;
    private JButton btnComprarFabricanteN3;
    
    // Botões para integrantes - Vendedor
    private JButton btnComprarVendedorN1;
    private JButton btnComprarVendedorN2;
    private JButton btnComprarVendedorN3;
    
    // Botões para integrantes - Segurança
    private JButton btnComprarSegurancaN1;
    private JButton btnComprarSegurancaN2;
    private JButton btnComprarSegurancaN3;
    
    // Botões para melhorias
    private JButton btnMelhoriaNivel1;
    private JButton btnMelhoriaNivel2;
    private JButton btnMelhoriaNivel3;
    
    // Botões para influencers
    private JButton btnInfluencerPequeno;
    private JButton btnInfluencerMedio;
    private JButton btnInfluencerGrande;

    private DashboardPanel dashboardPanel;
    
    // Botão para vender mercadorias
    private JButton btnVenderMercadorias;
    
    // Botão voltar
    private JButton btnVoltar;
    
    public LojaPanel(Favela favela, JFrame parentFrame, DashboardPanel dashboardPanel) {
        this.favela = favela;
        this.parentFrame = parentFrame;
        this.dashboardPanel = dashboardPanel;
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
        
        // Botões de integrantes - Fabricante
        btnComprarFabricanteN1 = criarBotaoItem("Fabricante Nível 1", "Produz 2 mercadorias/4s", 100.0);
        btnComprarFabricanteN2 = criarBotaoItem("Fabricante Nível 2", "Produz 10 mercadorias/8s", 250.0);
        btnComprarFabricanteN3 = criarBotaoItem("Fabricante Nível 3", "Produz 30 mercadorias/10s", 600.0);
        
        // Botões de integrantes - Vendedor
        btnComprarVendedorN1 = criarBotaoItem("Vendedor Nível 1", "Bônus de venda: +1.5", 150.0);
        btnComprarVendedorN2 = criarBotaoItem("Vendedor Nível 2", "Bônus de venda: +3.0", 300.0);
        btnComprarVendedorN3 = criarBotaoItem("Vendedor Nível 3", "Bônus de venda: +5.0", 650.0);
        
        // Botões de integrantes - Segurança
        btnComprarSegurancaN1 = criarBotaoItem("Segurança Nível 1", "Reduz risco em 10%", 200.0);
        btnComprarSegurancaN2 = criarBotaoItem("Segurança Nível 2", "Reduz risco em 20%", 350.0);
        btnComprarSegurancaN3 = criarBotaoItem("Segurança Nível 3", "Reduz risco em 35%", 700.0);
        
        // Botões de melhorias
        btnMelhoriaNivel1 = criarBotaoItem("Melhoria Nível 1", "Pequena melhoria na favela", 
                Melhoria.NivelUpgrade.NIVEL1.getMelhoriaPreco());
        btnMelhoriaNivel2 = criarBotaoItem("Melhoria Nível 2", "Melhoria média na favela", 
                Melhoria.NivelUpgrade.NIVEL2.getMelhoriaPreco());
        btnMelhoriaNivel3 = criarBotaoItem("Melhoria Nível 3", "Grande melhoria na favela", 
                Melhoria.NivelUpgrade.NIVEL3.getMelhoriaPreco());
        
        // Botões de influencers
        btnInfluencerPequeno = criarBotaoItem("Influencer Pequeno", "Bônus de venda: +R$ 50", 300.0);
        btnInfluencerMedio = criarBotaoItem("Influencer Médio", "Bônus de venda: +R$ 150", 800.0);
        btnInfluencerGrande = criarBotaoItem("Influencer Grande", "Bônus de venda: +R$ 350", 1500.0);
        
        // Botão para vender mercadorias
        btnVenderMercadorias = new JButton();
        btnVenderMercadorias.setText("Vender Mercadorias");
        btnVenderMercadorias.setFont(new Font("Arial", Font.BOLD, 14));
        btnVenderMercadorias.setBackground(new Color(70, 130, 180));
        btnVenderMercadorias.setForeground(Color.WHITE);
        btnVenderMercadorias.setBorderPainted(false);
        btnVenderMercadorias.setFocusPainted(false);
        btnVenderMercadorias.setPreferredSize(new Dimension(250, 80));
        
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
        
        JLabel titulo = new JLabel(" LOJA");
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
        
    // Painel central com seções - 3 linhas x 2 colunas (mais 1 linha extra para melhorias)
    JPanel painelCentral = new JPanel(new BorderLayout(10, 10));
    painelCentral.setBackground(new Color(45, 45, 45));
    painelCentral.setBorder(new EmptyBorder(20, 20, 0, 20));
    
    // Painel superior com grade 2x2 para funcionários
    JPanel painelFuncionarios = new JPanel(new GridLayout(2, 2, 10, 10));
    painelFuncionarios.setBackground(new Color(45, 45, 45));

    // Seção de Fabricantes
    JPanel secaoFabricantes = criarSecao("FABRICANTES", 
        new JButton[]{btnComprarFabricanteN1, btnComprarFabricanteN2, btnComprarFabricanteN3});

    // Seção de Vendedores
    JPanel secaoVendedores = criarSecao("VENDEDORES", 
        new JButton[]{btnComprarVendedorN1, btnComprarVendedorN2, btnComprarVendedorN3});

    // Seção de Seguranças
    JPanel secaoSegurancas = criarSecao("SEGURANÇAS", 
        new JButton[]{btnComprarSegurancaN1, btnComprarSegurancaN2, btnComprarSegurancaN3});
    
    // Seção de Influencers
    JPanel secaoInfluencers = criarSecao("INFLUENCERS", 
        new JButton[]{btnInfluencerPequeno, btnInfluencerMedio, btnInfluencerGrande});

    painelFuncionarios.add(secaoFabricantes);
    painelFuncionarios.add(secaoVendedores);
    painelFuncionarios.add(secaoSegurancas);
    painelFuncionarios.add(secaoInfluencers);
    
    // Painel inferior para melhorias (ocupa toda a largura)
    JPanel painelMelhorias = criarSecao("MELHORIAS DA FAVELA", 
        new JButton[]{btnMelhoriaNivel1, btnMelhoriaNivel2, btnMelhoriaNivel3});
    painelMelhorias.setPreferredSize(new Dimension(0, 150));
    
    painelCentral.add(painelFuncionarios, BorderLayout.CENTER);
    painelCentral.add(painelMelhorias, BorderLayout.SOUTH);
        
    // Painel inferior com botão de vender mercadorias centralizado e botão voltar à esquerda
    JPanel painelInferior = new JPanel(new BorderLayout());
    painelInferior.setBackground(new Color(45, 45, 45));
    painelInferior.setBorder(new EmptyBorder(10, 20, 20, 20));

    JPanel painelBotoesInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
    painelBotoesInferior.setBackground(new Color(45, 45, 45));
    painelBotoesInferior.add(btnVenderMercadorias);

    painelInferior.add(btnVoltar, BorderLayout.WEST);
    painelInferior.add(painelBotoesInferior, BorderLayout.CENTER);

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
    // Fabricantes
    btnComprarFabricanteN1.addActionListener(e -> comprarIntegrante("Fabricante", 1, 100.0));
    btnComprarFabricanteN2.addActionListener(e -> comprarIntegrante("Fabricante", 2, 250.0));
    btnComprarFabricanteN3.addActionListener(e -> comprarIntegrante("Fabricante", 3, 600.0));
    
    // Vendedores
    btnComprarVendedorN1.addActionListener(e -> comprarIntegrante("Vendedor", 1, 150.0));
    btnComprarVendedorN2.addActionListener(e -> comprarIntegrante("Vendedor", 2, 300.0));
    btnComprarVendedorN3.addActionListener(e -> comprarIntegrante("Vendedor", 3, 650.0));
    
    // Seguranças
    btnComprarSegurancaN1.addActionListener(e -> comprarIntegrante("Seguranca", 1, 200.0));
    btnComprarSegurancaN2.addActionListener(e -> comprarIntegrante("Seguranca", 2, 350.0));
    btnComprarSegurancaN3.addActionListener(e -> comprarIntegrante("Seguranca", 3, 700.0));
    
    // Influencers
    btnInfluencerPequeno.addActionListener(e -> contratarInfluencer("Pequeno", 50.0, 300.0));
    btnInfluencerMedio.addActionListener(e -> contratarInfluencer("Médio", 150.0, 800.0));
    btnInfluencerGrande.addActionListener(e -> contratarInfluencer("Grande", 350.0, 1500.0));
        
    btnMelhoriaNivel1.addActionListener(e -> comprarMelhoria(Melhoria.NivelUpgrade.NIVEL1));
    btnMelhoriaNivel2.addActionListener(e -> comprarMelhoria(Melhoria.NivelUpgrade.NIVEL2));
    btnMelhoriaNivel3.addActionListener(e -> comprarMelhoria(Melhoria.NivelUpgrade.NIVEL3));
        
    btnVenderMercadorias.addActionListener(e -> venderMercadorias());
        
    btnVoltar.addActionListener(e -> voltarMenu());
    }
    
    private void comprarIntegrante(String tipo, int nivel, double preco) {
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
                    // Fazer upgrade do integrante até o nível desejado
                    for (int i = 1; i < nivel; i++) {
                        novoIntegrante.upgradeNivel(favela);
                    }
                    
                    favela.adicionarIntegrante(novoIntegrante);
                    mostrarMensagem("Sucesso!", tipo + " Nível " + nivel + " contratado com sucesso!");
                    atualizarInformacoes();
                    dashboardPanel.atualizarDashboard(favela);
                }
            }
        } else {
            mostrarMensagem("Erro!", "Saldo insuficiente para contratar " + tipo + " Nível " + nivel + "!");
        }
    }
    
    private void comprarMelhoria(Melhoria.NivelUpgrade nivelUpgrade) {
    double preco = nivelUpgrade.getMelhoriaPreco();

    if (favela.getSaldoDinheiro() >= preco) {
        if (favela.gastarDinheiro(preco)) {

            // AUMENTA O NÍVEL DA FAVELA
            favela.subirNivel(nivelUpgrade.getNivel());

            mostrarMensagem(
                "Sucesso!",
                "Melhoria Nível " + nivelUpgrade.getNivel() + " adquirida!"
            );

            // Atualiza a tela da loja
            atualizarInformacoes();


            dashboardPanel.atualizarDashboard(favela);
        }
    } else {
        mostrarMensagem("Erro!", "Saldo insuficiente para esta melhoria!");
    }
}
    
    private void contratarInfluencer(String tamanho, double bonusVenda, double custo) {
        if (favela.getSaldoDinheiro() >= custo) {
            if (favela.gastarDinheiro(custo)) {
                Influencer novoInfluencer = new Influencer("Influencer " + tamanho, bonusVenda);
                favela.adicionarInfluencer(novoInfluencer);
                
                mostrarMensagem("Sucesso!", 
                    "Influencer " + tamanho + " contratado! Cada venda agora dará +R$ " + 
                    String.format("%.2f", bonusVenda) + " de bônus!");
                
                atualizarInformacoes();
                dashboardPanel.atualizarDashboard(favela);
            }
        } else {
            mostrarMensagem("Erro!", "Saldo insuficiente para contratar Influencer " + tamanho + "!");
        }
    }
    
    private void venderMercadorias() {
        int quantidade = favela.getMercadoriaTotal();
        if (quantidade > 0) {
            double valorBase = quantidade * favela.getTaxaVendaMercadoria();
            double bonusInfluencers = favela.calcularBonusInfluencers();
            double valorTotal = valorBase + bonusInfluencers;
            
            favela.venderMercadoria(quantidade);
            
            String mensagem = quantidade + " mercadorias vendidas!\n" +
                            "Valor base: R$ " + String.format("%.2f", valorBase);
            
            if (bonusInfluencers > 0) {
                mensagem += "\nBônus de influencers: +R$ " + String.format("%.2f", bonusInfluencers);
            }
            
            mensagem += "\nTotal recebido: R$ " + String.format("%.2f", valorTotal);
            
            mostrarMensagem("Sucesso!", mensagem);
            dashboardPanel.atualizarDashboard(favela);
            atualizarInformacoes();
        } else {
            mostrarMensagem("Erro!", "Você não possui mercadorias para vender!");
        }
    }
    
    private void voltarMenu() {
        if (parentFrame != null && dashboardPanel != null) {
            parentFrame.setContentPane(dashboardPanel);
            parentFrame.revalidate();
            parentFrame.repaint();
        }
    }
    
    private void atualizarInformacoes() {
        labelSaldo.setText(" Saldo: R$ " + String.format("%.2f", favela.getSaldoDinheiro()));
        labelMercadorias.setText(" Mercadorias: " + favela.getMercadoriaTotal());
        
        // Atualizar disponibilidade dos botões baseada no saldo
        atualizarDisponibilidadeBotoes();
    }
    
    private void atualizarDisponibilidadeBotoes() {
        double saldo = favela.getSaldoDinheiro();
        
        // Fabricantes
        btnComprarFabricanteN1.setEnabled(saldo >= 100.0);
        btnComprarFabricanteN2.setEnabled(saldo >= 250.0);
        btnComprarFabricanteN3.setEnabled(saldo >= 600.0);
        
        // Vendedores
        btnComprarVendedorN1.setEnabled(saldo >= 150.0);
        btnComprarVendedorN2.setEnabled(saldo >= 300.0);
        btnComprarVendedorN3.setEnabled(saldo >= 650.0);
        
        // Seguranças
        btnComprarSegurancaN1.setEnabled(saldo >= 200.0);
        btnComprarSegurancaN2.setEnabled(saldo >= 350.0);
        btnComprarSegurancaN3.setEnabled(saldo >= 700.0);
        
        // Influencers
        btnInfluencerPequeno.setEnabled(saldo >= 300.0);
        btnInfluencerMedio.setEnabled(saldo >= 800.0);
        btnInfluencerGrande.setEnabled(saldo >= 1500.0);
        
        btnMelhoriaNivel1.setEnabled(saldo >= Melhoria.NivelUpgrade.NIVEL1.getMelhoriaPreco());
        btnMelhoriaNivel2.setEnabled(saldo >= Melhoria.NivelUpgrade.NIVEL2.getMelhoriaPreco());
        btnMelhoriaNivel3.setEnabled(saldo >= Melhoria.NivelUpgrade.NIVEL3.getMelhoriaPreco());
        
        btnVenderMercadorias.setEnabled(favela.getMercadoriaTotal() > 0);
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
