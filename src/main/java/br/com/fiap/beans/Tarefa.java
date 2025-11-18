package br.com.fiap.beans;

public class Tarefa {

    private int id_tarefa;
    private String descricao_tarefa;
    private int pontos_tarefa;
    private String status_tarefa;
    private String data_fim_tarefa;
    private int id_funcionario;
    private int id_equipe;

    // Metodo Contrutor
    public Tarefa() {

    }

    public Tarefa(int id_tarefa, String descricao_tarefa, int pontos_tarefa, String status_tarefa, String data_fim_tarefa, int id_funcionario, int id_equipe) {
        this.id_tarefa = id_tarefa;
        this.descricao_tarefa = descricao_tarefa;
        this.pontos_tarefa = pontos_tarefa;
        this.status_tarefa = status_tarefa;
        this.data_fim_tarefa = data_fim_tarefa;
        this.id_funcionario = id_funcionario;
        this.id_equipe = id_equipe;
    }

    public int getId_tarefa() {
        return id_tarefa;
    }

    public void setId_tarefa(int id_tarefa) {
        this.id_tarefa = id_tarefa;
    }

    public String getDescricao_tarefa() {
        return descricao_tarefa;
    }

    public void setDescricao_tarefa(String descricao_tarefa) {
        this.descricao_tarefa = descricao_tarefa;
    }

    public int getPontos_tarefa() {
        return pontos_tarefa;
    }

    public void setPontos_tarefa(int pontos_tarefa) {
        this.pontos_tarefa = pontos_tarefa;
    }

    public String getStatus_tarefa() {
        return status_tarefa;
    }

    public void setStatus_tarefa(String status_tarefa) {
        this.status_tarefa = status_tarefa;
    }

    public String getData_fim_tarefa() {
        return data_fim_tarefa;
    }

    public void setData_fim_tarefa(String data_fim_tarefa) {
        this.data_fim_tarefa = data_fim_tarefa;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }
}
