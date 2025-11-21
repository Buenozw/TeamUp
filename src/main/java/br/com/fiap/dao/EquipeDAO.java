package br.com.fiap.dao;

import br.com.fiap.beans.Equipe;
import br.com.fiap.conexao.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipeDAO {

    public EquipeDAO() {
        // Construtor padrão
    }

    // Inserir
    public String inserir(Equipe equipe) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO EQUIPE (NOME_EQUIPE, DESCRICAO_EQUIPE) VALUES (?, ?)";

        try (Connection conn = new ConexaoFactory().conexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, equipe.getNome_equipe());
            stmt.setString(2, equipe.getDescricao_equipe());

            stmt.executeUpdate();
            return "Equipe cadastrada com sucesso";
        }
    }

    public void entrarEquipe(int idEquipe) throws ClassNotFoundException, SQLException {
        Connection conn = ConexaoFactory.conexao();
        String sql = "UPDATE equipe SET entrou = 1 WHERE id_equipe = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idEquipe);
        ps.executeUpdate();
        ps.close();
    }


    // Sair equipe
    public void sairEquipe(int idEquipe) throws SQLException, ClassNotFoundException {
        Connection conn = ConexaoFactory.conexao();
        PreparedStatement stmt = conn.prepareStatement(
                "UPDATE equipe SET entrou = 0 WHERE id_equipe = ?"
        );
        stmt.setInt(1, idEquipe);
        stmt.executeUpdate();
    }


    // Deletar
    public String deletar(int idEquipe) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM EQUIPE WHERE ID_EQUIPE = ?";

        try (Connection conn = new ConexaoFactory().conexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idEquipe);
            stmt.executeUpdate();

            return "Equipe deletada com sucesso";
        }
    }

    // Atualizar
    public String atualizar(Equipe equipe) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE EQUIPE SET NOME_EQUIPE = ?, DESCRICAO_EQUIPE = ? WHERE ID_EQUIPE = ?";

        try (Connection conn = new ConexaoFactory().conexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, equipe.getNome_equipe());
            stmt.setString(2, equipe.getDescricao_equipe());
            stmt.setInt(3, equipe.getId_equipe());

            stmt.executeUpdate();
            return "Equipe atualizada com sucesso";
        }
    }

    // Selecionar
    public List<Equipe> selecionar() throws SQLException, ClassNotFoundException {
        List<Equipe> lista = new ArrayList<>();

        String sql = "SELECT * FROM EQUIPE";

        try (Connection conn = new ConexaoFactory().conexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Equipe e = new Equipe();
                e.setId_equipe(rs.getInt("ID_EQUIPE"));
                e.setNome_equipe(rs.getString("NOME_EQUIPE"));
                e.setDescricao_equipe(rs.getString("DESCRICAO_EQUIPE"));
                lista.add(e);
            }
        }

        return lista;
    }
}
