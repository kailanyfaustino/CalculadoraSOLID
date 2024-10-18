package br.ifes.doo.calculadora.model.operacao;

public interface IOperacao {
    int operar(int value1, int value2) throws ArithmeticException; // Mudando para float
}
