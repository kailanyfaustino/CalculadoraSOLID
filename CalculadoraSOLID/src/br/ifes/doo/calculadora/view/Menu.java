package br.ifes.doo.calculadora.view;

import br.ifes.doo.calculadora.model.dto.RequestDTO;
import br.ifes.doo.calculadora.model.dto.ResponseDTO;
import br.ifes.doo.calculadora.model.factories.IOperacaoFabrica;

import java.util.Scanner;

public class Menu {
    private final IOperacaoFabrica operacaoFabrica;

    public Menu(IOperacaoFabrica operacaoFabrica) {
        this.operacaoFabrica = operacaoFabrica;
    }

    public void show() {
        System.out.println("Bem-vindo a calculadora :)");
        System.out.println("Escolha uma das operações abaixo:");
        for (String operacao : operacaoFabrica.getOperacoesDisponiveis()) {
            System.out.println(operacao);
        }
    }


    public RequestDTO retriveValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome da operação:");
        String opcao = scanner.nextLine();
        System.out.println("Informe o valor 1 (int):");
        int valor1 = scanner.nextInt();
        System.out.println("Informe o valor 2 (int):");
        int valor2 = scanner.nextInt();

        return new RequestDTO(opcao, valor1, valor2);
    }

    public void showResults(ResponseDTO responseDTO) {
        System.out.println("Resultado: " + responseDTO.getResult());
    }
}
