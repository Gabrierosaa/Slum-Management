package com.slummanagement.testes;

import com.slummanagement.modelo.Favela;
import com.slummanagement.modelo.Vendedor;

public class TesteVendedor {
    public static void main(String[] args) {
        Favela favela = new Favela("Teste", "Favela do Vendedor");
        Vendedor vendedor = new Vendedor("Vendedor Teste");
        favela.adicionarIntegrante(vendedor);

        double saldoAntes = favela.getSaldoDinheiro();
        System.out.println("Saldo inicial: R$" + saldoAntes);

        // Aplica o efeito do vendedor (bônus de venda)
        vendedor.aplicarEfeito(favela);
        double saldoDepois = favela.getSaldoDinheiro();
        System.out.println("Saldo após bônus do vendedor: R$" + saldoDepois);
        System.out.println("Bônus aplicado: R$" + vendedor.getBonusVenda());

        // Sobe o nível da favela e verifica se o vendedor sobe junto
        favela.subirNivel(1); // Favela nível 1 -> 2
        System.out.println("Nível do vendedor após subir nível da favela: " + vendedor.getNivel());
        vendedor.aplicarEfeito(favela);
        System.out.println("Saldo após novo bônus: R$" + favela.getSaldoDinheiro());
    }
}
