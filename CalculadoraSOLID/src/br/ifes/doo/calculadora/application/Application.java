package br.ifes.doo.calculadora.application;

import br.ifes.doo.calculadora.controller.ControllerCalc;
import br.ifes.doo.calculadora.model.calculadora.Calculadora;
import br.ifes.doo.calculadora.model.calculadora.ICalculadora;
import br.ifes.doo.calculadora.model.dto.RequestDTO;
import br.ifes.doo.calculadora.model.dto.ResponseDTO;
import br.ifes.doo.calculadora.model.exception.DivisaoPorZeroException;
import br.ifes.doo.calculadora.model.exception.OperacaoInvalidaException;
import br.ifes.doo.calculadora.model.factories.OperacaoFabrica;
import br.ifes.doo.calculadora.model.factories.IOperacaoFabrica;
import br.ifes.doo.calculadora.view.Menu;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        try {
            IOperacaoFabrica operacaoFabrica = new OperacaoFabrica();
            ICalculadora calculadora = new Calculadora(operacaoFabrica);
            ControllerCalc controllerCalc = new ControllerCalc(calculadora);
            Menu menu = new Menu(operacaoFabrica);
            Scanner scanner = new Scanner(System.in);
            boolean continuar = true;

            while (continuar) {
                menu.show();
                RequestDTO requestDTO = menu.retriveValue();
                ResponseDTO responseDTO = controllerCalc.Calcular(requestDTO);
                menu.showResults(responseDTO); // Mostra o resultado

                System.out.println("Deseja realizar outra operação? (s/n)");
                String resposta = scanner.nextLine();
                continuar = resposta.equalsIgnoreCase("s"); // Define se o loop deve continuar
            }
        } catch (OperacaoInvalidaException e) {
            System.err.println("Essa opção não existe");
        } catch (DivisaoPorZeroException e) {
            System.err.println("Não é possível fazer divisão por zero");
        } catch (Exception x) {
            System.err.println("Erro inesperado: " + x.getMessage());
        }
    }
}
