package com.slummanagement.modelo;

// ESTE É O IMPORT CRUCIAL: A interface AcaoJogo está no pacote 'controle'
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
        this.nivel = 1; // Todos começam no Nível 1
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
        return false; // Já está no nível máximo
    }

    /**
     * Retorna o custo do próximo upgrade.
     */

    @Override
    public double getCusto() {        
        return getCustoProximoUpgrade();
    }
     
    public double getCustoProximoUpgrade() {
        if (nivel == 1) return CUSTO_NIVEL_2;
        if (nivel == 2) return CUSTO_NIVEL_3;
        return 0.0; // Já é nível 3
    }
    
    // Implementação básica do AcaoJogo (Contratação)
    @Override
    public void executar(Favela favela) {
        favela.adicionarIntegrante(this);
        // NOTA: A lógica de custo de CONTRATAÇÃO (custo inicial) pode estar aqui
        // ou ser tratada no JogoController, junto com o JogoController.comprarItem.
    }
    
    // --- Métodos Abstratos (Polimorfismo para o Efeito Único) ---
    
    // Método que define o efeito específico de cada profissão (fabricar, vender, proteger)
    public abstract void aplicarEfeito(Favela favela); 
    public abstract boolean upgradeNivel(Favela favela);

    
    // --- Getters ---
    public int getNivel() {
        return this.nivel;
    }
    
    // NOTA: Esta classe é "abstract" porque não faz sentido instanciar um "Integrante" genérico.
}