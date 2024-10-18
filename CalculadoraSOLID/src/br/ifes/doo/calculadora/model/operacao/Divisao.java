package br.ifes.doo.calculadora.model.operacao;

import br.ifes.doo.calculadora.model.exception.DivisaoPorZeroException;

public class Divisao implements IOperacao{
    @Override
    public int operar(int value1, int value2) throws  ArithmeticException{
        if (value2 == 0 ) throw  new DivisaoPorZeroException();
        return value1 / value2;
    }
}
