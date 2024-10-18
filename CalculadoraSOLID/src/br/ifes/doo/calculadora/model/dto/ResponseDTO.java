package br.ifes.doo.calculadora.model.dto;

public class ResponseDTO {

    public ResponseDTO(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    int result;

}
