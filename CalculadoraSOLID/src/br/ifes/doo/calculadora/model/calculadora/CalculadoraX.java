package br.ifes.doo.calculadora.model.calculadora;

import br.ifes.doo.calculadora.model.dto.RequestDTO;
import br.ifes.doo.calculadora.model.dto.ResponseDTO;
import br.ifes.doo.calculadora.model.exception.DivisaoPorZeroException;
import br.ifes.doo.calculadora.model.exception.OperacaoInvalidaException;
import br.ifes.doo.calculadora.model.factories.IOperacaoFabrica;
import br.ifes.doo.calculadora.model.factories.OperacaoFabrica;
import br.ifes.doo.calculadora.model.operacao.IOperacao;

public class CalculadoraX implements ICalculadora {
    private final IOperacaoFabrica operacaoFabrica;

    public CalculadoraX(IOperacaoFabrica operacaoFabrica) {
        this.operacaoFabrica = operacaoFabrica;
    }

    @Override
    public ResponseDTO calcular(RequestDTO requestDTO) throws OperacaoInvalidaException, DivisaoPorZeroException {
        System.out.println("Vai meu filho");
        IOperacao operacao = operacaoFabrica.criar(requestDTO.getOpcao());

        int value1 = requestDTO.getValor1();
        int value2 = requestDTO.getValor2();
        int result = -1;

        if (operacao != null) {
            result = operacao.operar(value1, value2);
        }

        return new ResponseDTO(result);
    }
}
