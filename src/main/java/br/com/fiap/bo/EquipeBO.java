package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Equipe;
import br.com.fiap.dao.EquipeDAO;

public class EquipeBO {

    EquipeDAO equipeDAO;

    // Selecionar
    public ArrayList<Equipe> selecionarBo() throws ClassNotFoundException, SQLException {
        equipeDAO = new EquipeDAO();
        return (ArrayList<Equipe>) equipeDAO.selecionar();
    }

    // Entrar na equipe
    public void entrarEquipeBo(int idEquipe) throws ClassNotFoundException, SQLException {
        EquipeDAO equipeDAO = new EquipeDAO();
        equipeDAO.entrarEquipe(idEquipe);
    }

    // Sair equipe
    public void sairEquipeBo(int idEquipe) throws ClassNotFoundException, SQLException {
        EquipeDAO equipeDAO = new EquipeDAO();
        equipeDAO.sairEquipe(idEquipe);
    }



    // Inserir
    public void inserirBo(Equipe equipe) throws ClassNotFoundException, SQLException {
        EquipeDAO equipeDAO = new EquipeDAO();
        equipeDAO.inserir(equipe);
    }


    // Atualizar
    public void atualizarBo(Equipe equipe) throws ClassNotFoundException, SQLException {
        EquipeDAO equipeDAO = new EquipeDAO();
        equipeDAO.atualizar(equipe);
    }


    // Deletar
    public void deletarBo(int idEquipe) throws ClassNotFoundException, SQLException {
        EquipeDAO equipeDAO = new EquipeDAO();
        equipeDAO.deletar(idEquipe);
    }

}
