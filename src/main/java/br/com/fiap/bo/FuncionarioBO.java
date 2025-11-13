package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Funcionario;
import br.com.fiap.dao.FuncionarioDAO;

public class FuncionarioBO {

    FuncionarioDAO funcionarioDAO;

    // Selecionar
    public ArrayList<Funcionario> selecionarBo() throws ClassNotFoundException, SQLException {
        funcionarioDAO = new FuncionarioDAO();
        return (ArrayList<Funcionario>) funcionarioDAO.selecionar();
    }


    // Inserir
    public void inserirBo(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.inserir(funcionario);
    }


    // Atualizar
    public void atualizarBo(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.atualizar(funcionario);
    }


    // Deletar
    public void deletarBo(int idFuncionario) throws ClassNotFoundException, SQLException {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.deletar(idFuncionario);
    }
}
