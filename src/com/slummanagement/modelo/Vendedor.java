package com.slummanagement.modelo;

public class Vendedor extends Integrante {

    // Atributos específicos do vendedor
    private double bonusVenda;

    public Vendedor(String nome) {
        super(nome);
        // Valor inicial (Nível 1)
        this.bonusVenda = 1.5;
    }

    // NOVO: Sobrescreve o upgradeNivel para ajustar o bônus
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
        // Aplica o bônus de venda na favela
        favela.aplicarBonusVenda(this.bonusVenda);
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    // Getters específicos, se precisar
    public double getBonusVenda() {
        return bonusVenda;
    }
}