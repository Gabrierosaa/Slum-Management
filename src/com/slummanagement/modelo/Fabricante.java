package com.slummanagement.modelo;

public class Fabricante extends Integrante {
    
    // Atributos específicos do fabricante
    private int mercadoriasPorCiclo;
    private int tempoCicloSegundos;
    private int tempoDecorridoSegundos; // Tempo acumulado desde a última produção
    

    public Fabricante(String nome) {
        super(nome); // Chama o construtor da classe base (Integrante)
        // Valores iniciais (Nível 1)
        this.mercadoriasPorCiclo = 2;
        this.tempoCicloSegundos = 4;
        this.tempoDecorridoSegundos = 0; // Inicia o contador de tempo
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
        // Incrementa o tempo decorrido (chamado a cada segundo pelo Simulador)
        tempoDecorridoSegundos++;
        
        // Verifica se completou um ciclo de produção
        if (tempoDecorridoSegundos >= tempoCicloSegundos) {
            // Produz mercadoria
            favela.adicionarMercadoria(this.mercadoriasPorCiclo);
            System.out.println("[FABRICANTE " + nome + "] Produziu " + mercadoriasPorCiclo + " mercadorias!");
            
            // Reseta o contador
            tempoDecorridoSegundos = 0;
        }
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
    
    // Getters específicos
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