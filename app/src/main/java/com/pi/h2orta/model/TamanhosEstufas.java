package com.pi.h2orta.model;

public class TamanhosEstufas {

    private String tamanho;
    private String valor;
    private String informacoes;

    public TamanhosEstufas() {
    }

    public TamanhosEstufas(String tamanho, String valor, String informacoes) {
        this.tamanho = tamanho;
        this.valor = valor;
        this.informacoes = informacoes;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        valor = valor;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }
}
