package com.slummanagement.modelo;

public class Influencer {
    private final String nomeInfluencer;
    private final double dinheiro;

    public Influencer(String nomeInfluencer, double dinheiro){
        this.nomeInfluencer = nomeInfluencer;
        this.dinheiro = dinheiro;
    }

    public String getNomeInfluencer(){
        return nomeInfluencer;
    }

    public double getDinheiro(){
        return dinheiro;
    }
}
