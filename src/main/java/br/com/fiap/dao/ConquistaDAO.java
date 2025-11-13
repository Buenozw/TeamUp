package br.com.fiap.dao;

import br.com.fiap.beans.Conquista;
import br.com.fiap.conexao.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConquistaDAO {

    public Connection minhaConexao;

    public ConquistaDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }


    // Inserir
    public String inserir(Conquista conquista) throws SQLException {
        PreparedStatement stmt =
                minhaConexao.prepareStatement("INSERT INTO CONQUISTA (NOME_CONQUISTA, CRITERIO_CONQUISTA) VALUES (?, ?)");
        stmt.setString(1, conquista.getNome_conquista());
        stmt.setInt(2, conquista.getCriterio_conquista());

        stmt.execute();
        stmt.close();

        return "Conquista cadastrada com sucesso ✅";
    }


    // Delete
    public String deletar(int idConquista) throws SQLException {
        PreparedStatement stmt =
                minhaConexao.prepareStatement("DELETE FROM CONQUISTA WHERE ID_CONQUISTA = ?");
        stmt.setInt(1, idConquista);

        stmt.execute();
        stmt.close();

        return "Conquista deletada com sucesso ✅!";
    }


    // Atualizar
    public String atualizar(Conquista conquista) throws SQLException {
        PreparedStatement stmt =
                minhaConexao.prepareStatement("UPDATE CONQUISTA SET NOME_CONQUISTA = ?, CRITERIO_CONQUISTA = ? WHERE ID_CONQUISTA = ?");
        stmt.setString(1, conquista.getNome_conquista());
        stmt.setInt(2, conquista.getCriterio_conquista());
        stmt.setInt(3, conquista.getId_consquista());

        stmt.executeUpdate();
        stmt.close();

        return "Conquista atualizada com sucesso ✅!";
    }


    // Selecionar
    public List<Conquista> selecionar() throws SQLException {
        ArrayList<Conquista> listConquista = new ArrayList<Conquista>();

        PreparedStatement stmt =
                minhaConexao.prepareStatement("SELECT * FROM CONQUISTA");

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Conquista objConquista = new Conquista();
            objConquista.setId_consquista(rs.getInt("ID_CONQUISTA"));
            objConquista.setNome_conquista(rs.getString("NOME_CONQUISTA"));
            objConquista.setCriterio_conquista(rs.getInt("CRITERIO_CONQUISTA"));
            listConquista.add(objConquista);
        }
        return listConquista;
    }
}
