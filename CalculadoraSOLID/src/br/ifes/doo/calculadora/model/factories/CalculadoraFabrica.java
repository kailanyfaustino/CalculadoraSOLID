package br.ifes.doo.calculadora.model.factories;

import br.ifes.doo.calculadora.model.calculadora.ICalculadora;
import br.ifes.doo.calculadora.model.exception.OperacaoInvalidaException;

public class CalculadoraFabrica extends AbstractFactory<ICalculadora> {

    public CalculadoraFabrica(){
        super.pacoteBase = super.pacoteBase+".calculadora.";
    }


}
