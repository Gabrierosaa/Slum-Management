package com.slummanagement.modelo;

public class Melhoria {
    public enum NivelUpgrade {
        NIVEL1(1, 500),
        NIVEL2(2, 3000),
        NIVEL3(3, 6000);

        public final int nivel;
        public final double melhoriaPreco;

        NivelUpgrade(int nivel, double melhoriaPreco) {
            this.nivel = nivel;
            this.melhoriaPreco = melhoriaPreco; 
        }

        public int getNivel(){
            return nivel; 
        }

        public double getMelhoriaPreco() {
            return melhoriaPreco;
        }

    }

    private NivelUpgrade nivelUpgrade;

    public Melhoria(NivelUpgrade nivelUpgrade) {
        this.nivelUpgrade = nivelUpgrade;
    }

    public NivelUpgrade getNivelUpgrade() {
        return nivelUpgrade;
    }

    public void setNivelUpgrade(NivelUpgrade nivelUpgrade) {
        this.nivelUpgrade = nivelUpgrade;
    }

    public double getMelhoriaPreco() {
        return nivelUpgrade.getMelhoriaPreco();
    }

    @Override
    public String toString() {
        return "melhoria{" +
                "nivelUpgrade=" + nivelUpgrade +
                '}' ;
    }
}
