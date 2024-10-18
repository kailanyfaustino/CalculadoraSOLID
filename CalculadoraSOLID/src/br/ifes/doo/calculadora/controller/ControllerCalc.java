package br.ifes.doo.calculadora.controller;

import br.ifes.doo.calculadora.model.calculadora.ICalculadora;
import br.ifes.doo.calculadora.model.dto.RequestDTO;
import br.ifes.doo.calculadora.model.dto.ResponseDTO;
import br.ifes.doo.calculadora.model.calculadora.Calculadora;
import br.ifes.doo.calculadora.model.exception.DivisaoPorZeroException;
import br.ifes.doo.calculadora.model.exception.OperacaoInvalidaException;

public class ControllerCalc {
    private final ICalculadora calculadora;

    public ControllerCalc(ICalculadora calculadora) {
        this.calculadora = calculadora;
    }

    public ResponseDTO Calcular(RequestDTO requestDTO) throws OperacaoInvalidaException, DivisaoPorZeroException {
        return calculadora.calcular(requestDTO);
    }
}
