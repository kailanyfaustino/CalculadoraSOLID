package br.ifes.doo.calculadora.model.factories;

import br.ifes.doo.calculadora.model.exception.OperacaoInvalidaException;
import br.ifes.doo.calculadora.model.operacao.*;

import java.util.*;

public class OperacaoFabrica implements IOperacaoFabrica, IFactory<IOperacao> {

    private final Map<String, IOperacao> operacoes;

    public OperacaoFabrica() {
        operacoes = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        operacoes.put("Somar", new Somar());
        operacoes.put("Subtrair", new Subtrair());
        operacoes.put("Multiplicar", new Multiplicar());
        operacoes.put("Dividir", new Divisao());
    }

    @Override
    public IOperacao criar(String opcao) throws OperacaoInvalidaException {
        IOperacao operacao = operacoes.get(opcao);
        if (operacao == null) {
            throw new OperacaoInvalidaException("Operação inválida: " + opcao);
        }
        return operacao;
    }

    public void registrarOperacao(String nome, IOperacao operacao) {
        operacoes.put(nome, operacao);
    }

    public Set<String> getOperacoesDisponiveis() {
        return new HashSet<>(operacoes.keySet());
    }
}
