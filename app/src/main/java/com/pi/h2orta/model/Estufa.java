package com.pi.h2orta.model;

public class Estufa {

    private String modelo;
    private String descricao;
    private int imagem;

    public Estufa() {
    }

    public Estufa(String modelo, String descricao, int imagem) {
        this.modelo = modelo;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
