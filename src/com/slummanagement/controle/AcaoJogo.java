package com.slummanagement.controle;
import com.slummanagement.modelo.Favela; 

/**
 * Interface AcaoJogo: Define um contrato (o que o item faz) para 
 * qualquer objeto no jogo que possa ser comprado ou que inicie uma ação com custo.
 * * Este contrato permite ao JogoController tratar Integrantes e Melhorias 
 * de forma polimórfica (uniforme).
 */
public interface AcaoJogo {

    /**
     * Executa a ação principal do item (ex: Contratação, Aplicação de Bônus).
     * O JogoController chama este método DEPOIS de verificar e deduzir o custo.
     * * @param favela A instância da Favela onde a ação será aplicada (o alvo da mudança de estado).
     */
    void executar(Favela favela);

    /**
     * Retorna o nome do item.
     * @return O nome do item para exibição na interface (ex: "Fabricante Nível 1").
     */
    String getNome();

    /**
     * Retorna o custo do item.
     * @return O custo total (em dinheiro) para comprar este item.
     */
    double getCusto();
}