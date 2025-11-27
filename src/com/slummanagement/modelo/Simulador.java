package com.slummanagement.modelo;

import com.slummanagement.visao.DashboardPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;


public class Simulador {
    private Favela favela;
    private Timer timer;
    private Random random = new Random();
    private final int INTERVALO_TICK_MS = 1000; 
    private DashboardPanel dashboardPanel;

    
    public void iniciarJogo(Favela favela) {
        this.favela = favela;
        this.random = new Random();
        System.out.println("Jogo iniciado!");
        
        iniciarLoopTempo();
    }
    
    public void setDashboardPanel(DashboardPanel dashboardPanel) {
        this.dashboardPanel = dashboardPanel;
    }

    public void iniciarLoopTempo() {
        if (timer != null && timer.isRunning()) {
            return;
        }
        
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

    private void avancarTempo() {
        aplicarEfeitosIntegrantes();
        
        checarEventosAleatorios();
    }
 
    private void aplicarEfeitosIntegrantes() {
        for (Integrante integrante : favela.getIntegrantes()) {
            integrante.aplicarEfeito(favela); 
        }
    }

    private void checarEventosAleatorios() {
        if (random.nextDouble() < 0.005) { 
            processarInvasao();
        }
    }
    
    private void processarInvasao() {
        double perda = favela.getSaldoDinheiro() * 0.15; // Perde 15% do saldo atual
        favela.gastarDinheiro(perda);
        
        String mensagem = "[INVASÃO] Sua favela foi invadida! Perdeu R$" + String.format("%.2f", perda);
        System.out.println(mensagem);
        
        // Adiciona mensagem no painel se disponível
        if (dashboardPanel != null) {
            dashboardPanel.adicionarMensagem(mensagem);
        }
    }
}
