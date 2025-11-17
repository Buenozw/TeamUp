package br.com.fiap.dao;

import br.com.fiap.beans.Missao;
import br.com.fiap.conexao.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MissaoDAO {

    public Connection minhaConexao;

    public MissaoDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Inserir
    public String inserir(Missao missao) throws SQLException {
        PreparedStatement stmt =
                minhaConexao.prepareStatement("INSERT INTO MISSOES (TITULO, DESCRICAO, TIPO, XP_RECOMPENSA) VALUES (?, ?, ?, ?)");

        stmt.setString(1, missao.getTitulo());
        stmt.setString(2, missao.getDescricao());
        stmt.setString(3, missao.getTipo());
        stmt.setInt(4, missao.getXpRecompensa());

        stmt.execute();
        stmt.close();

        return "Missão cadastrada com sucesso ✅";
    }

    // Atualizar
    public String atualizar(Missao missao) throws SQLException {
        PreparedStatement stmt =
                minhaConexao.prepareStatement("UPDATE MISSOES SET TITULO = ?, DESCRICAO = ?, TIPO = ?, XP_RECOMPENSA = ? WHERE ID_MISSAO = ?");

        stmt.setString(1, missao.getTitulo());
        stmt.setString(2, missao.getDescricao());
        stmt.setString(3, missao.getTipo());
        stmt.setInt(4, missao.getXpRecompensa());
        stmt.setInt(5, missao.getIdMissao());

        stmt.executeUpdate();
        stmt.close();

        return "Missão atualizada com sucesso ✅!";
    }

    // Deletar
    public String deletar(int id_missao) throws SQLException {
        PreparedStatement stmt =
                minhaConexao.prepareStatement("DELETE FROM MISSOES WHERE ID_MISSAO = ?");

        stmt.setInt(1, id_missao);

        stmt.execute();
        stmt.close();

        return "Missão deletada com sucesso ✅!";
    }

    // Selecionar
    public List<Missao> selecionar() throws SQLException {
        ArrayList<Missao> listMissoes = new ArrayList<>();

        PreparedStatement stmt =
                minhaConexao.prepareStatement("SELECT * FROM MISSOES");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Missao missao = new Missao();
            missao.setIdMissao(rs.getInt("ID_MISSAO"));
            missao.setTitulo(rs.getString("TITULO"));
            missao.setDescricao(rs.getString("DESCRICAO"));
            missao.setTipo(rs.getString("TIPO"));
            missao.setXpRecompensa(rs.getInt("XP_RECOMPENSA"));
            listMissoes.add(missao);
        }

        return listMissoes;
    }
}
