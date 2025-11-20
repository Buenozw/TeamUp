package br.com.fiap.beans;

public class Equipe extends Funcionario {

    private int id_equipe;
    private String nome_equipe;
    private String descricao_equipe;

    public Equipe() {
    }

    public Equipe(int id_equipe, String nome_equipe, String descricao_equipe) {
        this.id_equipe = id_equipe;
        this.nome_equipe = nome_equipe;
        this.descricao_equipe = descricao_equipe;

    }


    public int getId_equipe() {
        return id_equipe;
    }


    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }

    public String getNome_equipe() {
        return nome_equipe;
    }

    public void setNome_equipe(String nome_equipe) {
        this.nome_equipe = nome_equipe;
    }

    public String getDescricao_equipe() {
        return descricao_equipe;
    }

    public void setDescricao_equipe(String descricao_equipe) {
        this.descricao_equipe = descricao_equipe;
    }

}