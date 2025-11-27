package com.slummanagement.modelo;

public class Vendedor extends Integrante {

    // Atributos específicos do vendedor
    private double bonusVenda;

    public Vendedor(String nome) {
        super(nome);
        this.bonusVenda = 1.5;
    }

    // Sobrescreve o upgradeNivel para ajustar o bônus
    @Override
    public boolean upgradeNivel() {
        if (super.upgradeNivel()) {
            if (nivel == 2) {
                this.bonusVenda = 3.0;
            } else if (nivel == 3) {
                this.bonusVenda = 5.0;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean upgradeNivel(Favela favela) {
        if (super.upgradeNivel()) {
            if (nivel == 2) {
                this.bonusVenda = 3.0;
            } else if (nivel == 3) {
                this.bonusVenda = 5.0;
            }
            return true;
        }
        return false;
    }

    @Override
    public void aplicarEfeito(Favela favela) {
        favela.aplicarBonusVenda(this.bonusVenda);
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    public double getBonusVenda() {
        return bonusVenda;
    }
}