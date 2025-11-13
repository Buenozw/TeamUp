package br.com.fiap.dao;

import br.com.fiap.beans.Equipe;
import br.com.fiap.conexao.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipeDAO {

    public Connection minhaConexao;

    public EquipeDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }


    // Inserir
    public String inserir(Equipe equipe) throws SQLException {
        PreparedStatement stmt =
                minhaConexao.prepareStatement("INSERT INTO EQUIPE (NOME_EQUIPE) VALUES (?)");
        stmt.setString(1, equipe.getNome_equipe());

        stmt.execute();
        stmt.close();

        return "Equipe cadastrada com sucesso ✅";
    }


    // Delete
    public String deletar(int idEquipe) throws SQLException {
        PreparedStatement stmt =
                minhaConexao.prepareStatement("DELETE FROM EQUIPE WHERE ID_EQUIPE = ?");
        stmt.setInt(1, idEquipe);

        stmt.execute();
        stmt.close();

        return "Equipe deletada com sucesso ✅!";
    }


    // Atualizar
    public String atualizar(Equipe equipe) throws SQLException {
        PreparedStatement stmt =
                minhaConexao.prepareStatement("UPDATE EQUIPE SET NOME_EQUIPE = ? WHERE ID_EQUIPE = ?");
        stmt.setString(1, equipe.getNome_equipe());
        stmt.setInt(2, equipe.getId_equipe());

        stmt.executeUpdate();
        stmt.close();

        return "Equipe atualizada com sucesso ✅!";
    }


    // Selecionar
    public List<Equipe> selecionar() throws SQLException {
        ArrayList<Equipe> listEquipe = new ArrayList<Equipe>();

        PreparedStatement stmt =
                minhaConexao.prepareStatement("SELECT * FROM EQUIPE");

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Equipe objEquipe = new Equipe();
            objEquipe.setId_equipe(rs.getInt("ID_EQUIPE"));
            objEquipe.setNome_equipe(rs.getString("NOME_EQUIPE"));
            listEquipe.add(objEquipe);
        }
        return listEquipe;
    }
}
