package br.ifes.doo.calculadora.model.factories;

public interface IFactory<T>{

    T criar(String opcao);

}
