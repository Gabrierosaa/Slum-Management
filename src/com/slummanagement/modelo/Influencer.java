package com.slummanagement.modelo;

public class Influencer {
    private final String nomeInfluencer;
    private final double bonusVenda;

    public Influencer(String nomeInfluencer, double bonusVenda){
        this.nomeInfluencer = nomeInfluencer;
        this.bonusVenda = bonusVenda;
    }

    public String getNomeInfluencer(){
        return nomeInfluencer;
    }

    public double getBonusVenda(){
        return bonusVenda;
    }
}
