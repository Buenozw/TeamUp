package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Tarefa;
import br.com.fiap.dao.TarefaDAO;

public class TarefaBO {

    TarefaDAO tarefaDAO;

    // Selecionar
    public ArrayList<Tarefa> selecionarBo() throws ClassNotFoundException, SQLException {
        tarefaDAO = new TarefaDAO();
        return (ArrayList<Tarefa>) tarefaDAO.selecionar();
    }


    // Inserir
    public void inserirBo(Tarefa tarefa) throws ClassNotFoundException, SQLException {
        TarefaDAO tarefaDAO = new TarefaDAO();
        tarefaDAO.inserir(tarefa);
    }


    // Atualizar
    public void atualizarBo(Tarefa tarefa) throws ClassNotFoundException, SQLException {
        TarefaDAO tarefaDAO = new TarefaDAO();
        tarefaDAO.atualizar(tarefa);
    }


    // Deletar
    public void deletarBo(int idTarefa) throws ClassNotFoundException, SQLException {
        TarefaDAO tarefaDAO = new TarefaDAO();
        tarefaDAO.deletar(idTarefa);
    }
}
