package br.com.fiap.dao;

import br.com.fiap.beans.Funcionario;
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
                minhaConexao.prepareStatement("INSERT INTO MISSAO (TITULO_MISSAO, DESCRICAO_MISSAO, TIPO_MISSAO, XP_RECOMPENSA_MISSAO) VALUES (?, ?, ?, ?)");

        stmt.setString(1, missao.getTitulo_missao());
        stmt.setString(2, missao.getDescricao_missao());
        stmt.setString(3, missao.getTipo_missao());
        stmt.setInt(4, missao.getXpRecompensa_missao());

        stmt.execute();
        stmt.close();

        return "Missão cadastrada com sucesso ✅";
    }

    // Atualizar
    public String atualizar(Missao missao) throws SQLException {
        PreparedStatement stmt =
                minhaConexao.prepareStatement("UPDATE MISSAO SET TITULO_MISSAO = ?, DESCRICAO_MISSAO = ?, TIPO_MISSAO = ?, XP_RECOMPENSA_MISSAO = ? WHERE ID_MISSAO = ?");

        stmt.setString(1, missao.getTitulo_missao());
        stmt.setString(2, missao.getDescricao_missao());
        stmt.setString(3, missao.getTipo_missao());
        stmt.setInt(4, missao.getXpRecompensa_missao());

        stmt.executeUpdate();
        stmt.close();

        return "Missão atualizada com sucesso ✅!";
    }

    // Deletar
    public String deletar(int id_missao) throws SQLException {
        PreparedStatement stmt =
                minhaConexao.prepareStatement("DELETE FROM MISSAO WHERE ID_MISSAO = ?");

        stmt.setInt(1, id_missao);

        stmt.execute();
        stmt.close();

        return "Missão deletada com sucesso ✅!";
    }

    // Selecionar
    public List<Missao> selecionar() throws SQLException {
        List<Missao> lista = new ArrayList<>();

        String sql = "SELECT * FROM MISSAO";

        try (PreparedStatement stmt = minhaConexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Missao f = new Missao();

                f.setId_missao(rs.getInt("ID_MISSAO"));
                f.setTitulo_missao(rs.getString("TITULO_MISSAO"));
                f.setDescricao_missao(rs.getString("DESCRICAO_MISSAO"));
                f.setTipo_missao(rs.getString("TIPO_MISSAO"));
                f.setXpRecompensa_missao(rs.getInt("XP_RECOMPENSA_MISSAO"));

                lista.add(f);
            }
        }

        return lista;
    }
}
