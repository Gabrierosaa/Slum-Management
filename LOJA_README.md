# 🏪 Tela de Loja - Slum Management

## Descrição
A tela de loja é uma interface completa para realizar compras no jogo Slum Management. Ela permite que os jogadores comprem integrantes, melhorias e mercadorias para desenvolver sua favela.

## Características da Loja

### 📊 Informações Principais
- **Saldo atual**: Mostra o dinheiro disponível do jogador
- **Mercadorias**: Quantidade de mercadorias no estoque
- **Interface visual**: Design moderno com tema escuro

### 👥 Integrantes Disponíveis
1. **Fabricante** - R$ 100,00
   - Produz mercadorias automaticamente
   - Essencial para gerar estoque

2. **Vendedor** - R$ 150,00
   - Aumenta o lucro das vendas
   - Aplica bônus nas transações

3. **Segurança** - R$ 200,00
   - Protege a favela de ataques
   - Garante segurança dos negócios

### 🏗️ Melhorias
1. **Nível 1** - R$ 500,00
   - Pequena melhoria na favela
   - Primeiro upgrade disponível

2. **Nível 2** - R$ 3.000,00
   - Melhoria média na favela
   - Upgrade intermediário

3. **Nível 3** - R$ 6.000,00
   - Grande melhoria na favela
   - Upgrade máximo

### 📦 Mercadorias
- **Pacote de 10 mercadorias** - R$ 20,00
- Adiciona mercadorias diretamente ao estoque
- Essencial quando a produção está baixa

## Como Usar

### Integração no Código
```java
// Criar uma instância da favela
Favela favela = new Favela("NomeJogador", "NomeFavela");

// Criar a janela principal
JFrame frame = new JFrame("Loja da Favela");

// Criar o painel da loja
LojaPanel loja = new LojaPanel(favela, frame);

// Adicionar à janela
frame.setContentPane(loja);
frame.setVisible(true);
```

### Funcionalidades Implementadas
- ✅ Verificação de saldo antes da compra
- ✅ Atualização automática das informações
- ✅ Habilitação/desabilitação de botões baseada no saldo
- ✅ Mensagens de sucesso e erro
- ✅ Interface responsiva e intuitiva
- ✅ Botão para voltar ao menu anterior

### Teste Rápido
Para testar a loja, execute:
```bash
javac -cp src src/com/slummanagement/testes/TesteLojaPanel.java
java -cp src com.slummanagement.testes.TesteLojaPanel
```

## Estrutura do Código

### Componentes Principais
- **LojaPanel**: Classe principal da interface
- **Seções organizadas**: Integrantes, Melhorias, Mercadorias
- **Sistema de eventos**: ActionListeners para cada botão
- **Validações**: Verificação de saldo e disponibilidade

### Métodos Importantes
- `comprarIntegrante()`: Lida com compra de funcionários
- `comprarMelhoria()`: Processa compras de upgrades
- `comprarMercadorias()`: Adiciona mercadorias ao estoque
- `atualizarInformacoes()`: Atualiza display de saldo e estoque
- `atualizarDisponibilidadeBotoes()`: Controla botões baseado no saldo

## Extensibilidade
A loja foi projetada para ser facilmente extensível:
- Adicione novos tipos de integrantes
- Implemente novos tipos de melhorias
- Customize preços e quantidades
- Adicione novos itens especiais

## Design Pattern Utilizado
- **Observer Pattern**: Para atualizações de interface
- **Command Pattern**: Para ações de compra
- **Factory Pattern**: Para criação de integrantes

A tela está pronta para uso e totalmente integrada com o sistema existente do jogo!