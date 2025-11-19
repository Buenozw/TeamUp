package br.com.fiap.dao;

import br.com.fiap.beans.Funcionario;
import br.com.fiap.conexao.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    private final Connection minhaConexao;

    public FuncionarioDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Inserir
    public String inserir(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO FUNCIONARIO (NOME_FUNCIONARIO, CARGO_FUNCIONARIO, EMAIL_FUNCIONARIO) " +
                "VALUES (?, ?, ?)";

        try (PreparedStatement stmt = minhaConexao.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome_funcionario());
            stmt.setString(2, funcionario.getCargo_funcionario());
            stmt.setString(3, funcionario.getEmail_funcionario());


            stmt.executeUpdate();
            return "Funcionário cadastrado com sucesso.";
        }
    }

    // Delete
    public String deletar(int idFuncionario) throws SQLException {
        String sql = "DELETE FROM FUNCIONARIO WHERE ID_FUNCIONARIO = ?";

        try (PreparedStatement stmt = minhaConexao.prepareStatement(sql)) {
            stmt.setInt(1, idFuncionario);

            int rows = stmt.executeUpdate();
            if (rows == 0) {
                return "Nenhum registro encontrado para exclusão.";
            }
            return "Funcionário deletado com sucesso.";
        }
    }

    // Atualizar
    public String atualizar(Funcionario funcionario) throws SQLException {
        String sql = "UPDATE FUNCIONARIO SET NOME_FUNCIONARIO = ?, CARGO_FUNCIONARIO = ?, " +
                "EMAIL_FUNCIONARIO = ? WHERE ID_FUNCIONARIO = ?";

        try (PreparedStatement stmt = minhaConexao.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome_funcionario());
            stmt.setString(2, funcionario.getCargo_funcionario());
            stmt.setString(4, funcionario.getEmail_funcionario());


            int rows = stmt.executeUpdate();
            if (rows == 0) {
                return "Nenhum registro encontrado para atualização.";
            }
            return "Funcionário atualizado com sucesso.";
        }
    }

    // Selecionar
    public List<Funcionario> selecionar() throws SQLException {
        List<Funcionario> lista = new ArrayList<>();

        String sql = "SELECT * FROM FUNCIONARIO";

        try (PreparedStatement stmt = minhaConexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Funcionario f = new Funcionario();

                f.setNome_funcionario(rs.getString("NOME_FUNCIONARIO"));
                f.setCargo_funcionario(rs.getString("CARGO_FUNCIONARIO"));
                f.setEmail_funcionario(rs.getString("EMAIL_FUNCIONARIO"));


                lista.add(f);
            }
        }

        return lista;
    }
}
