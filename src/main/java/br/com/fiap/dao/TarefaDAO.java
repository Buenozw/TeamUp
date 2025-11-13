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
                minhaConexao.prepareStatement("INSERT INTO TAREFA (DESCRICAO, PONTOS, STATUS, ID_FUNCIONARIO) VALUES (?, ?, ?, ?)");
        stmt.setString(1, tarefa.getDescricao());
        stmt.setInt(2, tarefa.getPontos());
        stmt.setString(3, tarefa.getStatus());
        stmt.setInt(4, tarefa.getId_funcionario());

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
                minhaConexao.prepareStatement("UPDATE TAREFA SET DESCRICAO = ?, PONTOS = ?, STATUS = ?, ID_FUNCIONARIO = ? WHERE ID_TAREFA = ?");
        stmt.setString(1, tarefa.getDescricao());
        stmt.setInt(2, tarefa.getPontos());
        stmt.setString(3, tarefa.getStatus());
        stmt.setInt(4, tarefa.getId_funcionario());
        stmt.setInt(5, tarefa.getId_tarefa());

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
            objTarefa.setDescricao(rs.getString("DESCRICAO"));
            objTarefa.setPontos(rs.getInt("PONTOS"));
            objTarefa.setStatus(rs.getString("STATUS"));
            objTarefa.setId_funcionario(rs.getInt("ID_FUNCIONARIO"));
            listTarefa.add(objTarefa);
        }
        return listTarefa;
    }
}
