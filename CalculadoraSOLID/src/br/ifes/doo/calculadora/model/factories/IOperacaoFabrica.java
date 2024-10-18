package br.ifes.doo.calculadora.model.factories;

import br.ifes.doo.calculadora.model.exception.OperacaoInvalidaException;
import br.ifes.doo.calculadora.model.operacao.IOperacao;

import java.util.Set;

public interface IOperacaoFabrica {
    IOperacao criar(String opcao) throws OperacaoInvalidaException;
    Set<String> getOperacoesDisponiveis();
    void registrarOperacao(String nome, IOperacao operacao);
}
