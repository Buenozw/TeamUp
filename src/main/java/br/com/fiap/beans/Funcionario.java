package br.com.fiap.beans;

public class Funcionario extends Usuario {

    private String nome_funcionario;
    private String cargo_funcionario;
    private int pontos_funcionario;
    private String email_funcionario;
    private int id_equipe;

    // Metodo Contrutor
    public Funcionario() {
    }

    public Funcionario(String nome_funcionario, String cargo_funcionario, int pontos_funcionario, String email_funcionario, int id_equipe) {
        this.nome_funcionario = nome_funcionario;
        this.cargo_funcionario = cargo_funcionario;
        this.pontos_funcionario = pontos_funcionario;
        this.email_funcionario = email_funcionario;
        this.id_equipe = id_equipe;
    }

    // Getters e Setters

    public String getNome_funcionario() {
        return nome_funcionario;
    }

    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    public String getCargo_funcionario() {
        return cargo_funcionario;
    }

    public void setCargo_funcionario(String cargo_funcionario) {
        this.cargo_funcionario = cargo_funcionario;
    }

    public int getPontos_funcionario() {
        return pontos_funcionario;
    }

    public void setPontos_funcionario(int pontos_funcionario) {
        this.pontos_funcionario = pontos_funcionario;
    }

    public String getEmail_funcionario() {
        return email_funcionario;
    }

    public void setEmail_funcionario(String email_funcionario) {
        this.email_funcionario = email_funcionario;
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }
}



