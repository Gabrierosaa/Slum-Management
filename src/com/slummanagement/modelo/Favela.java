package com.slummanagement.modelo;

import java.util.ArrayList;
import java.util.List;

public class Favela {
    //atributos da classe
    private final String nomeJogador;
    private final String nomeFavela;
    private double saldoDinheiro;
    private int mercadoriaTotal;

    // 🔥 Novo atributo de nível
    private int nivel;

    //entidades da favela
    private final List<Integrante> integrantes = new ArrayList<>(); 
    private final List<Influencer> influencers = new ArrayList<>();

    // Método para adicionar integrante
    public void adicionarIntegrante(Integrante novoIntegrante) { 
        if (novoIntegrante != null) {
            this.integrantes.add(novoIntegrante);  
        }
    }
    
    // Método para adicionar influencer
    public void adicionarInfluencer(Influencer novoInfluencer) {
        if (novoInfluencer != null) {
            this.influencers.add(novoInfluencer);
        }
    }

    //Construtor
    public Favela(String nomeJogador, String nomeFavela) {
        this.nomeJogador = nomeJogador;
        this.nomeFavela = nomeFavela;
        this.saldoDinheiro = 1000.0; //saldo inicial
        this.mercadoriaTotal = 100; //mercadoria inicial
        this.nivel = 0; // 🔥 nível inicial
    }

    //Metodos getters e setters
    public String getNomeFavela() {
        return nomeFavela;
    }
    
    public String getNomeJogador() {
        return nomeJogador;
    }

    public double getSaldoDinheiro() {
        return saldoDinheiro;
    }

    public int getMercadoriaTotal() {
        return mercadoriaTotal;
    }

    public List<Integrante> getIntegrantes() {
        return integrantes; 
    }
    
    public List<Influencer> getInfluencers() {
        return influencers;
    }

    public int getNivel() {
        return nivel;
    }

    public void subirNivel(int quantidade) {
        if (quantidade > 0) {
            this.nivel += quantidade;
            // Sincroniza o nível dos funcionários
            for (Integrante integrante : integrantes) {
                if (integrante instanceof Fabricante || integrante instanceof Vendedor) {
                    // Sobe o nível do integrante até igualar ao da favela
                    while (integrante.nivel < this.nivel) {
                        integrante.upgradeNivel();
                    }
                }
            }
        }
    }

    //============METODOS DE NEGOCIO============//
    public void adicionarMercadoria(int quantidade) {
        if (quantidade > 0) {
            this.mercadoriaTotal += quantidade;         
        }
    }

    public boolean venderMercadoria(int quantidade) {
        final double TAXA_VENDA = 1.5;

        if (quantidade <= 0 || quantidade > this.mercadoriaTotal) {
            return false;
        }

        // Calcula valor base
        double valorRecebido = quantidade * TAXA_VENDA;
        
        // Aplica bônus dos influencers
        double bonusInfluencers = calcularBonusInfluencers();
        valorRecebido += bonusInfluencers;

        this.mercadoriaTotal -= quantidade;
        this.saldoDinheiro += valorRecebido;
     
        return true;
    }
    
    /**
     * Calcula o bônus total de vendas de todos os influencers
     */
    public double calcularBonusInfluencers() {
        double bonusTotal = 0.0;
        for (Influencer influencer : influencers) {
            bonusTotal += influencer.getBonusVenda();
        }
        return bonusTotal;
    }

    public void aplicarBonusVenda(double bonus) {
        this.saldoDinheiro += bonus;
    }

    public boolean gastarDinheiro(double valor) {
        if (valor <= 0 || valor > this.saldoDinheiro) {
            return false;
        }
        this.saldoDinheiro -= valor;
        return true;
    }

    public double getTaxaVendaMercadoria() {
        return 1.5;
    }
}
