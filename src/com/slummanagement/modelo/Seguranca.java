package com.slummanagement.modelo;

public class Seguranca extends Integrante {
    
    private double bonusReducaoRisco;

    public Seguranca(String nome) {
        super(nome);
        // Valor inicial (Nível 1)
        this.bonusReducaoRisco = 10.0; // 10% de redução de risco
    }
    
    // Implementação do efeito único: Reduzir o risco de invasão na Favela
    @Override
    public void aplicarEfeito(Favela favela) {
        // Aplica a redução de risco baseada no nível atual
        // Exemplo: favela.reduzirRisco(this.bonusReducaoRisco);
        // Por enquanto, vamos simular o efeito sem implementar reduzirRisco na Favela
    }
    
    @Override
    public boolean upgradeNivel(Favela favela) {
        if (super.upgradeNivel()) {
            if (nivel == 2) {
                this.bonusReducaoRisco = 20.0;
            } else if (nivel == 3) {
                this.bonusReducaoRisco = 35.0;
            }
            return true;
        }
        return false;
    }
    
    @Override
    public String getNome() {
        return this.nome;
    }
    

    public double getBonusReducaoRisco() {
        return this.bonusReducaoRisco;
    }
}