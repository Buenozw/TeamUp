package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Conquista;
import br.com.fiap.dao.ConquistaDAO;

public class ConquistaBO {

    ConquistaDAO conquistaDAO;

    // Selecionar
    public ArrayList<Conquista> selecionarBo() throws ClassNotFoundException, SQLException {
        conquistaDAO = new ConquistaDAO();
        return (ArrayList<Conquista>) conquistaDAO.selecionar();
    }


    // Inserir
    public void inserirBo(Conquista conquista) throws ClassNotFoundException, SQLException {
        ConquistaDAO conquistaDAO = new ConquistaDAO();
        conquistaDAO.inserir(conquista);
    }


    // Atualizar
    public void atualizarBo(Conquista conquista) throws ClassNotFoundException, SQLException {
        ConquistaDAO conquistaDAO = new ConquistaDAO();
        conquistaDAO.atualizar(conquista);
    }


    // Deletar
    public void deletarBo(int idConquista) throws ClassNotFoundException, SQLException {
        ConquistaDAO conquistaDAO = new ConquistaDAO();
        conquistaDAO.deletar(idConquista);
    }
}
