package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

public class UsuarioBO {

    UsuarioDAO usuarioDAO;

    // Selecionar
    public List<Usuario> selecionarBo() throws ClassNotFoundException, SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.listarTodos();
    }



    // Inserir
    public void inserirBo(Usuario usuario) throws ClassNotFoundException, SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.inserir(usuario);
    }


    // Atualizar
    public void atualizarBo(Usuario usuario) throws ClassNotFoundException, SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.atualizar(usuario);
    }


    // Deletar
    public void deletarBo(int idUsuario) throws ClassNotFoundException, SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.deletar(idUsuario);
    }
}
