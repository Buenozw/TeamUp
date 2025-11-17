package br.com.fiap.beans;

public class Missao {

    private int id_missao;
    private String titulo;
    private String descricao;
    private String tipo; // DIARIA ou SEMANAL
    private int xpRecompensa;

    // Metodo Contrutor
    public Missao() {

    }

    public Missao(int id_missao, String titulo, String descricao, String tipo, int xpRecompensa) {
        this.id_missao = id_missao;
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.xpRecompensa = xpRecompensa;
    }

    // Getters e Setters
    public int getIdMissao() {
        return id_missao;
    }

    public void setIdMissao(int idMissao) {
        this.id_missao = idMissao;
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
