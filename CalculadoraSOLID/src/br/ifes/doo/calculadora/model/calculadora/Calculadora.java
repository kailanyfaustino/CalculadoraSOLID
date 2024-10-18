package br.ifes.doo.calculadora.model.calculadora;

import br.ifes.doo.calculadora.model.dto.RequestDTO;
import br.ifes.doo.calculadora.model.dto.ResponseDTO;
import br.ifes.doo.calculadora.model.exception.DivisaoPorZeroException;
import br.ifes.doo.calculadora.model.exception.OperacaoInvalidaException;
import br.ifes.doo.calculadora.model.factories.OperacaoFabrica;
import br.ifes.doo.calculadora.model.factories.IOperacaoFabrica;
import br.ifes.doo.calculadora.model.operacao.IOperacao;

public class Calculadora implements ICalculadora {

    private final IOperacaoFabrica operacaoFabrica;

    public Calculadora(IOperacaoFabrica operacaoFabrica) {
        this.operacaoFabrica = operacaoFabrica;
    }

    @Override
    public ResponseDTO calcular(RequestDTO requestDTO) throws OperacaoInvalidaException, DivisaoPorZeroException {
        IOperacao operacao = operacaoFabrica.criar(String.valueOf(requestDTO.getOpcao()));
        int result = operacao.operar(requestDTO.getValor1(), requestDTO.getValor2());
        return new ResponseDTO(result);
    }
}
