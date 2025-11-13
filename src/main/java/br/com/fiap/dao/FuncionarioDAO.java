package br.com.fiap.dao;

import br.com.fiap.beans.Funcionario;
import br.com.fiap.conexao.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public Connection minhaConexao;

    public FuncionarioDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }


    // Inserir
    public String inserir(Funcionario funcionario) throws SQLException {
        PreparedStatement stmt =
                minhaConexao.prepareStatement("INSERT INTO FUNCIONARIO (CARGO, PONTOS, ID_EQUIPE) VALUES (?, ?, ?)");
        stmt.setString(1, funcionario.getCargo());
        stmt.setInt(2, funcionario.getPontos());
        stmt.setInt(3, funcionario.getId_equipe());

        stmt.execute();
        stmt.close();

        return "Funcionário cadastrado com sucesso ✅";
    }


    // Delete
    public String deletar(int idFuncionario) throws SQLException {
        PreparedStatement stmt =
                minhaConexao.prepareStatement("DELETE FROM FUNCIONARIO WHERE ID_FUNCIONARIO = ?");
        stmt.setInt(1, idFuncionario);

        stmt.execute();
        stmt.close();

        return "Funcionário deletado com sucesso ✅!";
    }


    // Atualizar
    public String atualizar(Funcionario funcionario) throws SQLException {
        PreparedStatement stmt =
                minhaConexao.prepareStatement("UPDATE FUNCIONARIO SET CARGO = ?, PONTOS = ?, ID_EQUIPE = ? WHERE ID_FUNCIONARIO = ?");
        stmt.setString(1, funcionario.getCargo());
        stmt.setInt(2, funcionario.getPontos());
        stmt.setInt(3, funcionario.getId_equipe());
        stmt.setInt(4, funcionario.getId_usuario()); // herdado de Usuario

        stmt.executeUpdate();
        stmt.close();

        return "Funcionário atualizado com sucesso ✅!";
    }


    // Selecionar
    public List<Funcionario> selecionar() throws SQLException {
        ArrayList<Funcionario> listFuncionario = new ArrayList<Funcionario>();

        PreparedStatement stmt =
                minhaConexao.prepareStatement("SELECT * FROM FUNCIONARIO");

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Funcionario objFuncionario = new Funcionario();
            objFuncionario.setId_usuario(rs.getInt("ID_FUNCIONARIO"));
            objFuncionario.setCargo(rs.getString("CARGO"));
            objFuncionario.setPontos(rs.getInt("PONTOS"));
            objFuncionario.setId_equipe(rs.getInt("ID_EQUIPE"));
            listFuncionario.add(objFuncionario);
        }
        return listFuncionario;
    }
}