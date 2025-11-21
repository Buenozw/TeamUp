package br.com.fiap.dao;

import br.com.fiap.beans.Tarefa;
import br.com.fiap.conexao.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {

    // Inserir
    public String inserir(Tarefa tarefa) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO TAREFA (DESCRICAO_TAREFA, PONTOS_TAREFA, DATA_FIM_TAREFA) VALUES (?, ?, ?)";

        try (Connection conn = new ConexaoFactory().conexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tarefa.getDescricao_tarefa());
            stmt.setInt(2, tarefa.getPontos_tarefa());
            stmt.setDate(3, Date.valueOf(tarefa.getData_fim_tarefa()));

            stmt.executeUpdate();
            return "Tarefa cadastrada com sucesso";
        }
        // Recursos fechados automaticamente pelo try-with-resources
    }

    // Deletar
    public String deletar(int idTarefa) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM TAREFA WHERE ID_TAREFA = ?";

        try (Connection conn = new ConexaoFactory().conexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idTarefa);
            stmt.executeUpdate();

            return "Tarefa deletada com sucesso";
        }
        // Conexão e statement liberados corretamente
    }

    // Atualizar
    public String atualizar(Tarefa tarefa) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE TAREFA SET DESCRICAO_TAREFA = ?, PONTOS_TAREFA = ?, DATA_FIM_TAREFA = ? WHERE ID_TAREFA = ?";

        try (Connection conn = new ConexaoFactory().conexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tarefa.getDescricao_tarefa());
            stmt.setInt(2, tarefa.getPontos_tarefa());
            stmt.setDate(3, Date.valueOf(tarefa.getData_fim_tarefa()));
            stmt.setInt(4, tarefa.getId_tarefa());

            stmt.executeUpdate();
            return "Tarefa atualizada com sucesso";
        }
        // Sessões encerradas de forma determinística
    }

    // Selecionar todos
    public List<Tarefa> selecionar() throws SQLException, ClassNotFoundException {
        List<Tarefa> lista = new ArrayList<>();

        String sql = "SELECT * FROM TAREFA";

        try (Connection conn = new ConexaoFactory().conexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Tarefa t = new Tarefa();
                t.setId_tarefa(rs.getInt("ID_TAREFA"));
                t.setDescricao_tarefa(rs.getString("DESCRICAO_TAREFA"));
                t.setPontos_tarefa(rs.getInt("PONTOS_TAREFA"));
                t.setData_fim_tarefa(rs.getDate("DATA_FIM_TAREFA").toString());
                lista.add(t);
            }
        }
        // Todos os recursos (conexão, statement e resultset) são automaticamente fechados

        return lista;
    }
}
