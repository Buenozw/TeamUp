package br.com.fiap.beans;

public class Missao {

    private int idMissao;
    private String titulo;
    private String descricao;
    private String tipo; // DIARIA ou SEMANAL
    private int xpRecompensa;

    // Metodo Contrutor
    public Missao() {

    }

    public Missao(int idMissao, String titulo, String descricao, String tipo, int xpRecompensa) {
        this.idMissao = idMissao;
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.xpRecompensa = xpRecompensa;
    }

    // Getters e Setters
    public int getIdMissao() {
        return idMissao;
    }

    public void setIdMissao(int idMissao) {
        this.idMissao = idMissao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getXpRecompensa() {
        return xpRecompensa;
    }

    public void setXpRecompensa(int xpRecompensa) {
        this.xpRecompensa = xpRecompensa;
    }
}
