package br.com.fiap.beans;

public class Equipe extends Funcionario {

    private int id_equipe;
    private String nome_equipe;

    // Metodo Contrutor
    public Equipe() {
    }

    public Equipe(int id_equipe, String nome_equipe) {
        this.id_equipe = id_equipe;
        this.nome_equipe = nome_equipe;
    }

    // Getters e Setters
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
}
