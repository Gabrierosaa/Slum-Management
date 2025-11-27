package com.slummanagement.modelo;

public class Fabricante extends Integrante {

    private int mercadoriasPorCiclo;
    private int tempoCicloSegundos;
    private int tempoDecorridoSegundos;
    

    public Fabricante(String nome) {
        super(nome);
        this.mercadoriasPorCiclo = 2;
        this.tempoCicloSegundos = 4;
        this.tempoDecorridoSegundos = 0;
    }
    
    @Override
    public boolean upgradeNivel() {
        if (super.upgradeNivel()) {
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

    @Override
    public void aplicarEfeito(Favela favela) {
        tempoDecorridoSegundos++;
        
        if (tempoDecorridoSegundos >= tempoCicloSegundos) {
            favela.adicionarMercadoria(this.mercadoriasPorCiclo);
            System.out.println("[FABRICANTE " + nome + "] Produziu " + mercadoriasPorCiclo + " mercadorias!");
            tempoDecorridoSegundos = 0;
        }
    }
    
    @Override
    public String getNome() {
        return this.nome;
    }
    
    @Override
    public boolean upgradeNivel(Favela favela) {
        if (super.upgradeNivel()) {
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
    
    public int getTempoCicloSegundos() {
        return this.tempoCicloSegundos;
    }
    
    public int getMercadoriasPorCiclo() {
        return this.mercadoriasPorCiclo;
    }
    
    public int getTempoDecorridoSegundos() {
        return this.tempoDecorridoSegundos;
    }
}