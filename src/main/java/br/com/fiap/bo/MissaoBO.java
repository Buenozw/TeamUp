package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Missao;
import br.com.fiap.dao.MissaoDAO;

public class MissaoBO {

    MissaoDAO missaoDAO;

    // Selecionar
    public ArrayList<Missao> selecionarBo() throws ClassNotFoundException, SQLException {
        missaoDAO = new MissaoDAO();
        return (ArrayList<Missao>) missaoDAO.selecionar();
    }

    // Inserir
    public void inserirBo(Missao missao) throws ClassNotFoundException, SQLException {
        MissaoDAO missaoDAO = new MissaoDAO();
        missaoDAO.inserir(missao);
    }

    // Atualizar
    public void atualizarBo(Missao missao) throws ClassNotFoundException, SQLException {
        MissaoDAO missaoDAO = new MissaoDAO();
        missaoDAO.atualizar(missao);
    }

    // Deletar
    public void deletarBo(int idMissao) throws ClassNotFoundException, SQLException {
        MissaoDAO missaoDAO = new MissaoDAO();
        missaoDAO.deletar(idMissao);
    }
}
