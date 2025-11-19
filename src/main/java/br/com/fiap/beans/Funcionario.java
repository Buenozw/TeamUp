package br.com.fiap.beans;

public class Funcionario  {

    private String nome_funcionario;
    private String cargo_funcionario;
    private String email_funcionario;


    // Metodo Contrutor
    public Funcionario() {
    }

    public Funcionario(String nome_funcionario, String cargo_funcionario,  String email_funcionario) {
        this.nome_funcionario = nome_funcionario;
        this.cargo_funcionario = cargo_funcionario;

        this.email_funcionario = email_funcionario;

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


    public String getEmail_funcionario() {
        return email_funcionario;
    }

    public void setEmail_funcionario(String email_funcionario) {
        this.email_funcionario = email_funcionario;
    }

}



