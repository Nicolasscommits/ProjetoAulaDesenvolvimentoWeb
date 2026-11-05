package com.curso.boot.domain;

public enum UF {

    AC("AC", "Acre"),
    AL("AL", "Alagoas"),
    AP("AP", "Amapá"),
    AM("AM", "Amazonas");

    private String sigla;
    private String descricao;

    UF(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}