package br.ifes.doo.calculadora.model.factories;

import br.ifes.doo.calculadora.model.exception.OperacaoInvalidaException;
import java.lang.reflect.InvocationTargetException;

public class AbstractFactory<T> implements IFactory<T> {

    protected String pacoteBase = "br.ifes.doo.calculadora.model.";

    @Override
    public T criar(String opcao) throws OperacaoInvalidaException {
        try {
            // Mapeamento da opção para o nome da classe correspondente
            String pacoteBaseCompleto = this.pacoteBase + opcao;

            // Usa reflexão para instanciar a classe correspondente
            Class<?> classeOperacao = Class.forName(pacoteBaseCompleto);
            return (T) classeOperacao.getDeclaredConstructor().newInstance(); // Retorna a instância criada

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new OperacaoInvalidaException("Erro ao criar instância da operação: " + e.getMessage());
        }
    }
}
