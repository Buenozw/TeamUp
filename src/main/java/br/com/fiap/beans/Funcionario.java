package br.com.fiap.beans;

public class Funcionario extends Usuario {


    private String cargo;
    private int pontos;
    private int id_equipe;

    // Metodo Contrutor
    public Funcionario() {
    }

    public Funcionario(String cargo, int pontos, int id_equipe) {
        this.cargo = cargo;
        this.pontos = pontos;
        this.id_equipe = id_equipe;
    }

    // Getters e Setters
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }
}



