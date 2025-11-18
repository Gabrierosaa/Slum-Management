package com.slummanagement.modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;


public class Simulador {
    private Favela favela;
    private Timer timer;
    private Random random = new Random();
    private final int INTERVALO_TICK_MS = 1000; 

    
    public void iniciarJogo(Favela favela) {
        this.favela = favela;
        this.random = new Random();
        System.out.println("Jogo iniciado!");
        
        // Inicia o loop de tempo automaticamente
        iniciarLoopTempo();
    }

    public void iniciarLoopTempo() {
        if (timer != null && timer.isRunning()) {
            return; // Já está rodando
        }
        
        // Define o que acontece a cada tick
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avancarTempo();
            }
        };
        
        this.timer = new Timer(INTERVALO_TICK_MS, listener);
        this.timer.start();
        System.out.println("Simulador iniciado. Tick a cada " + INTERVALO_TICK_MS + "ms.");
    }
    
    public void pararLoopTempo() {
        if (timer != null) {
            timer.stop();
            System.out.println("Simulador pausado.");
        }
    }

    // --- LÓGICA EXECUTADA A CADA TICK ---

    private void avancarTempo() {
        aplicarEfeitosIntegrantes();
        
        processarCustosRecorrentes(); 
        
        checarEventosAleatorios();
        
        // 4. (Futuramente) Notificar a Visão para atualizar o Dashboard
        // favela.notificarObservadores(); 
    }
    
    // --- LÓGICA ESPECÍFICA DO TYCOON ---
    
    /**
     * Itera sobre a lista de Integrantes e chama o método de efeito específico.
     */
    private void aplicarEfeitosIntegrantes() {
        // NOTE: Isso simula que o efeito de TODOS os integrantes ocorre a cada tick.
        // Fabricante: Fabrica Mercadoria (Se o tempo for certo - Lógica mais complexa).
        // Vendedor: Aumenta a taxa de venda.
        
        for (Integrante integrante : favela.getIntegrantes()) {
            // Chama o método polimórfico. A implementação real está em Fabricante, Vendedor, etc.
            integrante.aplicarEfeito(favela); 
        }
    }
    
    /**
     * Processa os custos de manutenção da Favela.
     */
    private void processarCustosRecorrentes() {
        // Lógica: Calcular o salário total dos Integrantes e deduzir da Favela
        // Se a lógica de salário for simples e a cada tick:
        // double custoTotalSalarios = calcularSalarioTotal();
        // favela.gastarDinheiro(custoTotalSalarios);
    }
    
    /**
     * Checa a probabilidade de um evento como Invasão ocorrer.
     */
    private void checarEventosAleatorios() {
        // RF05: Invasão de Favela
        // 0.5% de chance de invasão a cada segundo (tick)
        if (random.nextDouble() < 0.005) { 
            processarInvasao();
        }
    }
    
    /**
     * Executa a lógica do evento de Invasão (RF05).
     */
    private void processarInvasao() {
        double perda = favela.getSaldoDinheiro() * 0.15; // Perde 15% do saldo atual
        favela.gastarDinheiro(perda);
        
        System.out.println("[ALERTA DO SIMULADOR] Invasão! Perdeu R$" + String.format("%.2f", perda));
        
        // Futuramente: O JogoController será notificado para exibir o EventoPanel

    }
}
