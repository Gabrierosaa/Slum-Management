package com.slummanagement.modelo;

import java.util.ArrayList;
import java.util.List;

public class Favela {
    //atributos da classe
    private final String nomeJogador;
    private final String nomeFavela;
    private double saldoDinheiro;
    private int mercadoriaTotal;

    //entidades da favela
    private final List<Integrante> integrantes = new ArrayList<>(); 

// O método que resolve o erro de 'adicionarIntegrante is undefined'
    public void adicionarIntegrante(Integrante novoIntegrante) { 
        if (novoIntegrante != null) {
        this.integrantes.add(novoIntegrante);  
    }
}

    //Construtor
    public Favela(String nomeJogador, String nomeFavela) {
        this.nomeJogador = nomeJogador;
        this.nomeFavela = nomeFavela;
        this.saldoDinheiro = 1000.0; //saldo inicial
        this.mercadoriaTotal = 0; //mercadoria inicial
    }

    //Metodos getters e setters
    
    public String getNomeFavela() { //mostra o nome da favela
        return nomeFavela;
    }
    
    public String getNomeJogador() { //mostra o nome do jogador
        return nomeJogador;
    }

    public double getSaldoDinheiro() { //mostra o saldo de dinheiro
        return saldoDinheiro;
    }

    public int getMercadoriaTotal() { //mostra a mercadoria total
        return mercadoriaTotal;
    }
    public List<Integrante> getIntegrantes() { //mostra os integrantes da favela   
        return integrantes; 
    }

    //============METODOS DE NEGOCIO============//

    // Método para adicionar mercadoria
    public void adicionarMercadoria(int quantidade) {
        if (quantidade > 0) {
            this.mercadoriaTotal += quantidade;         
        }
    }

    // Método para vender mercadoria
    public boolean venderMercadoria(int quantidade) {
        final double TAXA_VENDA = 1.5; // valor de mercadoria
        
        if (quantidade <= 0 || quantidade > this.mercadoriaTotal) {
            return false; //não pode vender quantidade inválida
        }

        // 1. Calcula o dinheiro a ser recebido
        double valorRecebido = quantidade * TAXA_VENDA;

        // 2. Atualiza os saldos
        this.mercadoriaTotal -= quantidade;
        this.saldoDinheiro += valorRecebido;
     
        return true;
    }

    // Método para aplicar bônus de venda (usado pelos Vendedores)
    public void aplicarBonusVenda(double bonus) {
        // Pode ser implementado de diferentes formas, por exemplo:
        // - Aumentar temporariamente a taxa de venda
        // - Adicionar dinheiro diretamente baseado no bônus
        this.saldoDinheiro += bonus;
    }

    // Método para gastar dinheiro (usado para compras e upgrades)
    public boolean gastarDinheiro(double valor) {
        if (valor <= 0 || valor > this.saldoDinheiro) {
            return false; // Não pode gastar valor inválido ou maior que o saldo
        }
        this.saldoDinheiro -= valor;
        return true;
    }

    // Método para obter a taxa de venda atual de mercadoria
    public double getTaxaVendaMercadoria() {
        return 1.5; // Taxa fixa de venda
    }
}

