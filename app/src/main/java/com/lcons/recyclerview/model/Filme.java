package com.lcons.recyclerview.model;

public class Filme {
    private String tituloFilme;
    private String ano;
    private String genero;

    public Filme() {
    }

    public Filme(String tituloFilme, String ano, String genero) {
        this.tituloFilme = tituloFilme;
        this.ano = ano;
        this.genero = genero;
    }

    public String getTituloFilme() {
        return tituloFilme;
    }

    public void setTituloFilme(String tituloFilme) {
        this.tituloFilme = tituloFilme;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
