package com.slummanagement.modelo;

import java.util.ArrayList;
import java.util.List;

public class Favela {
    //atributos da classe
    private String nomeJogador;
    private String nomeFavela;
    private double saldoDinheiro;
    private int mercadoriaTotal;

    //entidades da favela
    private List<Integrante> integrantes = new ArrayList<>();

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
}

