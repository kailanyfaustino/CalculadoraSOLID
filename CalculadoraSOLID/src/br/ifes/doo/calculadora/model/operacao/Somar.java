package br.ifes.doo.calculadora.model.operacao;

public class Somar implements IOperacao{
    @Override
    public int operar(int value1, int value2) {
        return value1 + value2;
    }
}
