package com.slummanagement.modelo;
import com.slummanagement.controle.AcaoJogo; 
public abstract class Integrante implements AcaoJogo {

    // Atributos Comuns
    protected String nome;
    protected int nivel;
    
    // Custos de upgrade
    private static final double CUSTO_NIVEL_2 = 150.0;
    private static final double CUSTO_NIVEL_3 = 500.0;

    // Construtor
    public Integrante(String nome) {
        this.nome = nome;
        this.nivel = 1;
    }

    // --- Métodos de Nível e Upgrade ---
    
   
    public boolean upgradeNivel() {
        if (nivel == 1) {
            nivel = 2;
            return true;
        } else if (nivel == 2) {
            nivel = 3;
            return true;
        }
        return false;
    }

    @Override
    public double getCusto() {        
        return getCustoProximoUpgrade();
    }
     
    public double getCustoProximoUpgrade() {
        if (nivel == 1) return CUSTO_NIVEL_2;
        if (nivel == 2) return CUSTO_NIVEL_3;
        return 0.0;
    }
    
    // Implementação básica do AcaoJogo
    @Override
    public void executar(Favela favela) {
        favela.adicionarIntegrante(this);
    }
    
    public abstract void aplicarEfeito(Favela favela); 
    public abstract boolean upgradeNivel(Favela favela);

    

    public int getNivel() {
        return this.nivel;
    }
}