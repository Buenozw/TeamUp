package br.com.fiap.dao;

import br.com.fiap.beans.Usuario;
import br.com.fiap.conexao.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Connection conexao;

    public UsuarioDAO() throws SQLException, ClassNotFoundException {
        this.conexao = new ConexaoFactory().conexao();
    }

    // Inserir
    public Object inserir(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO USUARIO (NOME_USUARIO, EMAIL_USUARIO) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome_usuario());
            stmt.setString(2, usuario.getEmail_usuario());
            stmt.executeUpdate();
        }
        return null;
    }

    // Atualizar
    public Object atualizar(Usuario usuario) throws SQLException {
        String sql = "UPDATE USUARIO SET NOME_USUARIO = ?, EMAIL_USUARIO = ? WHERE ID_USUARIO = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome_usuario());
            stmt.setString(2, usuario.getEmail_usuario());
            stmt.setInt(3, usuario.getId_usuario());
            stmt.executeUpdate();
        }
        return null;
    }

    // Deletar
    public Object deletar(int idUsuario) throws SQLException {
        String sql = "DELETE FROM USUARIO WHERE ID_USUARIO = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();
        }
        return null;
    }

    // Buscar por ID
    public Usuario buscarPorId(int idUsuario) throws SQLException {
        String sql = "SELECT * FROM USUARIO WHERE ID_USUARIO = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario() {};
                    usuario.setId_usuario(rs.getInt("ID_USUARIO"));
                    usuario.setNome_usuario(rs.getString("NOME_USUARIO"));
                    usuario.setEmail_usuario(rs.getString("EMAIL_USUARIO"));
                    return usuario;
                }
            }
        }
        return null;
    }

    // Selecionar todos
    public List<Usuario> listarTodos() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM USUARIO";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario() {};
                usuario.setId_usuario(rs.getInt("ID_USUARIO"));
                usuario.setNome_usuario(rs.getString("NOME_USUARIO"));
                usuario.setEmail_usuario(rs.getString("EMAIL_USUARIO"));
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }
}
