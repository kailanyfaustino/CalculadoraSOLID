# Calculadora SOLID
Este projeto implementa uma calculadora simples seguindo os princípios SOLID de design de software para a disciplina de DOO.

## Estrutura do Projeto
O projeto está organizado em pacotes que refletem as diferentes responsabilidades e camadas da aplicação:
* application: Contém a classe principal que inicia a aplicação.
* controller: Gerencia o fluxo de controle entre a interface do usuário e a lógica de negócios.
* model: Contém as classes de domínio, DTOs, exceções e fábricas.
* view: Lida com a interação com o usuário.

## Princípios SOLID Aplicados
### 1. Princípio da Responsabilidade Única (SRP)
* Cada classe tem uma única responsabilidade bem definida.

* Exemplo: A classe `Somar` dentro de `model/operacao` é responsável apenas pela operação de soma.

```bash
public class Somar implements IOperacao{
    @Override
    public int operar(int value1, int value2) {
        return value1 + value2;
    }
}
```


### 2. Princípio Aberto-Fechado (OCP)
* O sistema é aberto para extensão, mas fechado para modificação.
* Novas operações podem ser adicionadas sem modificar o código existente.
* Exemplo: `OperacaoFabrica` em `model/factories`, permite adicionar novas operações facilmente.

### 3. Princípio da Substituição de Liskov (LSP)
* As classes derivadas podem ser substituídas por suas classes base.
* Exemplo: `Calculadora` e `CalculadoraX` implementam `ICalculadora`.

### 4. Princípio da Segregação de Interface (ISP)
* Interfaces específicas são preferíveis a uma única interface geral.
* Exemplo: `IOperacao` e `ICalculadora` são interfaces separadas e específicas.

### 5. Princípio da Inversão de Dependência (DIP)
* Módulos de alto nível não dependem de módulos de baixo nível. Ambos dependem de abstrações.
* Exemplo: `Menu` e `Calculadora` dependem de `IOperacaoFabrica`, não de uma implementação concreta.

```bash
    private final IOperacaoFabrica operacaoFabrica;
    public void show(){
    public Menu(IOperacaoFabrica operacaoFabrica) {
        this.operacaoFabrica = operacaoFabrica;
    }
```

## Como Executar
Para executar a calculadora, execute a `Main`.

## Extensibilidade
Para adicionar uma nova operação:
* Crie uma nova classe que implemente `IOperacao`.
* Adicione a nova operação em `OperacaoFabrica`.	