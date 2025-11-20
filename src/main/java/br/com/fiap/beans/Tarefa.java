package br.com.fiap.beans;

public class Tarefa {

    private int id_tarefa;
    private String descricao_tarefa;
    private int pontos_tarefa;
    private String data_fim_tarefa;

    // Metodo Contrutor
    public Tarefa() {

    }

    public Tarefa(int id_tarefa, String descricao_tarefa, int pontos_tarefa, String status_tarefa, String data_fim_tarefa, int id_funcionario, int id_equipe) {
        this.id_tarefa = id_tarefa;
        this.descricao_tarefa = descricao_tarefa;
        this.pontos_tarefa = pontos_tarefa;
        this.data_fim_tarefa = data_fim_tarefa;

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

    public String getData_fim_tarefa() {
        return data_fim_tarefa;
    }

    public void setData_fim_tarefa(String data_fim_tarefa) {
        this.data_fim_tarefa = data_fim_tarefa;
    }

}
