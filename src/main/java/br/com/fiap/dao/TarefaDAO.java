package br.com.fiap.dao;

import br.com.fiap.beans.Tarefa;
import br.com.fiap.conexao.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {

    public Connection minhaConexao;

    public TarefaDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Inserir
    public String inserir(Tarefa tarefa) throws SQLException {
        PreparedStatement stmt =
                minhaConexao.prepareStatement("INSERT INTO TAREFA (DESCRICAO_TAREFA, PONTOS_TAREFA, DATA_FIM_TAREFA ) VALUES (?, ?, ?)");
        stmt.setString(1, tarefa.getDescricao_tarefa());
        stmt.setInt(2, tarefa.getPontos_tarefa());
        stmt.setString(3, tarefa.getData_fim_tarefa());

        stmt.execute();
        stmt.close();

        return "Tarefa cadastrada com sucesso ✅";
    }

    // Delete
    public String deletar(int idTarefa) throws SQLException {
        PreparedStatement stmt =
                minhaConexao.prepareStatement("DELETE FROM TAREFA WHERE ID_TAREFA = ?");
        stmt.setInt(1, idTarefa);

        stmt.execute();
        stmt.close();

        return "Tarefa deletada com sucesso ✅!";
    }

    // Atualizar
    public String atualizar(Tarefa tarefa) throws SQLException {
        PreparedStatement stmt =
                minhaConexao.prepareStatement("UPDATE TAREFA SET DESCRICAO_TAREFA = ?, PONTOS_TAREFA = ?, DATA_FIM_TAREFA = ? WHERE ID_TAREFA = ?");
        stmt.setString(1, tarefa.getDescricao_tarefa());
        stmt.setInt(2, tarefa.getPontos_tarefa());
        stmt.setString(3, tarefa.getData_fim_tarefa());
        stmt.setInt(4, tarefa.getId_tarefa());

        stmt.executeUpdate();
        stmt.close();

        return "Tarefa atualizada com sucesso ✅!";
    }

    // Selecionar
    public List<Tarefa> selecionar() throws SQLException {
        ArrayList<Tarefa> listTarefa = new ArrayList<Tarefa>();

        PreparedStatement stmt =
                minhaConexao.prepareStatement("SELECT * FROM TAREFA");

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Tarefa objTarefa = new Tarefa();
            objTarefa.setId_tarefa(rs.getInt("ID_TAREFA"));
            objTarefa.setDescricao_tarefa(rs.getString("DESCRICAO_TAREFA"));
            objTarefa.setPontos_tarefa(rs.getInt("PONTOS_TAREFA"));
            objTarefa.setData_fim_tarefa(rs.getString("DATA_FIM_TAREFA"));
            listTarefa.add(objTarefa);
        }
        return listTarefa;
    }
}
