package com.slummanagement.modelo;

public class Fabricante extends Integrante {
    
    // Atributos específicos do fabricante
    private int mercadoriasPorCiclo;
    private int tempoCicloSegundos;
    

    public Fabricante(String nome) {
        super(nome); // Chama o construtor da classe base (Integrante)
        // Valores iniciais (Nível 1)
        this.mercadoriasPorCiclo = 2;
        this.tempoCicloSegundos = 4;
    }
    
    // NOVO: Sobrescreve o método upgradeNivel para ajustar os atributos específicos
    @Override
    public boolean upgradeNivel() {
        if (super.upgradeNivel()) { // Tenta o upgrade na classe base
            if (nivel == 2) {
                this.mercadoriasPorCiclo = 10;
                this.tempoCicloSegundos = 8;
            } else if (nivel == 3) {
                this.mercadoriasPorCiclo = 30;
                this.tempoCicloSegundos = 10;
            }
            return true;
        }
        return false;
    }

    // Implementação do efeito único: Adicionar mercadoria à Favela
    @Override
    public void aplicarEfeito(Favela favela) {
        // Esta lógica será chamada pelo Simulador a cada X segundos
        favela.adicionarMercadoria(this.mercadoriasPorCiclo);
    }
    
    @Override
    public String getNome() {
        return this.nome;
    }
    
    @Override
    public boolean upgradeNivel(Favela favela) {
        if (super.upgradeNivel()) { // Tenta o upgrade na classe base
            if (nivel == 2) {
                this.mercadoriasPorCiclo = 10;
                this.tempoCicloSegundos = 8;
            } else if (nivel == 3) {
                this.mercadoriasPorCiclo = 30;
                this.tempoCicloSegundos = 10;
            }
            return true;
        }
        return false;
    }
    
    // ... Getters específicos para o Simulador usar (getMercadoriasPorCiclo, getTempoCicloSegundos) ...
    public int getTempoCicloSegundos() {
        return this.tempoCicloSegundos;
    }
}