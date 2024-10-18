package br.ifes.doo.calculadora.model.calculadora;

import br.ifes.doo.calculadora.model.dto.RequestDTO;
import br.ifes.doo.calculadora.model.dto.ResponseDTO;
import br.ifes.doo.calculadora.model.exception.OperacaoInvalidaException;

public interface ICalculadora {

    public ResponseDTO calcular (RequestDTO requestDTO) throws OperacaoInvalidaException;
}


