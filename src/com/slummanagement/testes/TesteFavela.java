package com.slummanagement.testes;

import com.slummanagement.modelo.Favela;
import com.slummanagement.modelo.Fabricante;

public class TesteFavela {
    
    // Método auxiliar para imprimir o status atual da Favela
    public static void imprimirStatus(Favela f, String titulo) {
        System.out.println("\n--- STATUS ATUAL: " + titulo + " ---");
        System.out.println("Saldo Dinheiro: R$" + String.format("%.2f", f.getSaldoDinheiro()));
        System.out.println("Mercadoria Total: " + f.getMercadoriaTotal());
        System.out.println("Taxa de Venda: " + f.getTaxaVendaMercadoria());
        System.out.println("Integrantes Ativos: " + f.getIntegrantes().size());
        System.out.println("----------------------------------------");
    }
    
    public static void main(String[] args) {
        
        // 1. SETUP INICIAL
        System.out.println("INICIANDO TESTE DO MODELO DE NEGÓCIOS (FAVELA E INTEGRANTES)");
        Favela favela = new Favela("Sombra", "Complexo do Sol");
        
        // O custo de contratação inicial está em Integrante.java (ex: R$50.00)
        final double CUSTO_CONTRATACAO = 50.0; 
        
        imprimirStatus(favela, "INICIALIZAÇÃO");

        // ----------------------------------------------------------------------
        
        // 2. TESTE DE CONTRATAÇÃO (RF02) E POLIMORFISMO
        
        // Criando uma instância do Fabricante (Subclasse de Integrante)
        Fabricante fab1 = new Fabricante("João F. Nível 1");
        
        System.out.println("\n--- 2. CONTRATAÇÃO DE FABRICANTE ---");
        System.out.println("Custo de Contratação: R$" + CUSTO_CONTRATACAO);
        
        // Simulação da Ação do Jogo (Controlador verifica e gasta o dinheiro)
        
        // A) Gastar Dinheiro (Verifica se o saldo é suficiente)
        if (favela.gastarDinheiro(CUSTO_CONTRATACAO)) {
            
            // B) Executar a Ação (Polimorfismo: chama o Integrante.executar())
            // Nota: Integrante implementa AcaoJogo, então podemos testar o método executar
            fab1.executar(favela); 
            
            System.out.println("Contratação BEM-SUCEDIDA.");
        } else {
            System.out.println("FALHA na contratação: Dinheiro insuficiente.");
        }
        
        imprimirStatus(favela, "APÓS CONTRATAÇÃO"); 
        
        // ----------------------------------------------------------------------
        
        // 3. TESTE DE EFEITO (PRODUÇÃO)
        
        System.out.println("\n--- 3. TESTE DE PRODUÇÃO ---");
        
        // Simula o 'tick' do Simulador, chamando o efeito de produção
        System.out.println("Simulando a produção do Fabricante (2 Mercadorias)...");
        fab1.aplicarEfeito(favela); // Fabrica 2 mercadorias (lógica do Nível 1)

        imprimirStatus(favela, "APÓS PRODUÇÃO"); 
        
        // ----------------------------------------------------------------------
        
        // 4. TESTE DE UPGRADE DE NÍVEL
        
        double custoUpgrade = fab1.getCustoProximoUpgrade(); // Deve ser 150.0
        System.out.println("\n--- 4. TESTE DE UPGRADE ---");
        System.out.println("Fabricante Atual: " + fab1.getNome() + " (Nível " + fab1.getNivel() + ")");
        System.out.println("Custo para Nível 2: R$" + custoUpgrade);
        
        // A) Gasta o Dinheiro para Upgrade
        if (favela.gastarDinheiro(custoUpgrade)) {
            
            // B) Aplica o Upgrade (lógica dentro do Integrante/Fabricante)
            fab1.upgradeNivel(); 
            
            System.out.println("Upgrade BEM-SUCEDIDO para NÍVEL 2!");
            System.out.println("Novo Nível: " + fab1.getNivel());
            
        } else {
             System.out.println("FALHA no upgrade: Dinheiro insuficiente.");
        }
        
        imprimirStatus(favela, "APÓS UPGRADE"); 
        
        // ----------------------------------------------------------------------

        // 5. TESTE DE VENDA E TAXA VARIÁVEL (Economia)
        
        System.out.println("\n--- 5. TESTE DE VENDA E TAXA ---");
        
        // Vende todas as mercadorias restantes (52 mercadorias)
        int mercadoriasParaVender = favela.getMercadoriaTotal();
        boolean vendeu = favela.venderMercadoria(mercadoriasParaVender);
        
        if (vendeu) {
            // Saldo anterior: 1000 - 50 - 150 = 800.0
            // Valor Recebido: 52 * 1.5 = 78.0
            System.out.println("Venda TOTAL bem-sucedida. Mercadorias vendidas: " + mercadoriasParaVender);
            System.out.println("Saldo Final Esperado: R$ 800.0 + 78.0 = R$ 878.00");
        }
        
        imprimirStatus(favela, "FINAL DO TESTE");
    }
}