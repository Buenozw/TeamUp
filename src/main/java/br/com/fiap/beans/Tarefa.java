package br.com.fiap.beans;

public class Tarefa {

    private int id_tarefa;
    private String descricao;
    private int pontos;
    private String status;
    private int id_funcionario;

    // Metodo Contrutor
    public Tarefa() {

    }

    public Tarefa(int id, String descricao, int pontos, String status, int idFuncionario) {
        this.id_tarefa = id;
        this.descricao = descricao;
        this.pontos = pontos;
        this.status = status;
        this.id_funcionario = idFuncionario;
    }

    // Getters e Setters
    public int getId_tarefa() {
        return id_tarefa;
    }

    public void setId_tarefa(int id_tarefa) {
        this.id_tarefa = id_tarefa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }
}
