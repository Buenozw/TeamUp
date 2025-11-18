package br.com.fiap.beans;

public class Missao {

    private int id_missao;
    private String titulo_missao;
    private String descricao_missao;
    private String tipo_missao; // DIARIA ou SEMANAL
    private int xpRecompensa_missao;

    // Metodo Contrutor
    public Missao() {

    }

    public Missao(int id_missao, String titulo_missao, String descricao_missao, String tipo_missao, int xpRecompensa_missao) {
        this.id_missao = id_missao;
        this.titulo_missao = titulo_missao;
        this.descricao_missao = descricao_missao;
        this.tipo_missao = tipo_missao;
        this.xpRecompensa_missao = xpRecompensa_missao;
    }

    public int getId_missao() {
        return id_missao;
    }

    public void setId_missao(int id_missao) {
        this.id_missao = id_missao;
    }

    public String getTitulo_missao() {
        return titulo_missao;
    }

    public void setTitulo_missao(String titulo_missao) {
        this.titulo_missao = titulo_missao;
    }

    public String getDescricao_missao() {
        return descricao_missao;
    }

    public void setDescricao_missao(String descricao_missao) {
        this.descricao_missao = descricao_missao;
    }

    public String getTipo_missao() {
        return tipo_missao;
    }

    public void setTipo_missao(String tipo_missao) {
        this.tipo_missao = tipo_missao;
    }

    public int getXpRecompensa_missao() {
        return xpRecompensa_missao;
    }

    public void setXpRecompensa_missao(int xpRecompensa_missao) {
        this.xpRecompensa_missao = xpRecompensa_missao;
    }
}
