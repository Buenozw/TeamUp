package br.com.fiap.main;

import br.com.fiap.beans.*;
import br.com.fiap.dao.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class MenuPrincipal {

    // ---------------- VALIDAÇÕES ----------------

    static int inteiro(String msg) {
        while (true) {
            try {
                return Integer.parseInt(JOptionPane.showInputDialog(msg));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Digite um número válido!");
            }
        }
    }

    static String texto(String msg) {
        String t = JOptionPane.showInputDialog(msg);
        if (t == null) return "";
        return t;
    }

    static double decimal(String msg) {
        while (true) {
            try {
                return Double.parseDouble(JOptionPane.showInputDialog(msg));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Digite um número decimal válido!");
            }
        }
    }

    // ---------------- MENU PRINCIPAL ----------------

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        int opcao;

        do {
            opcao = inteiro(
                    " >>>>  MENU PRINCIPAL <<<< \n" +
                            "1 - Inserir\n" +
                            "2 - Listar\n" +
                            "3 - Atualizar\n" +
                            "4 - Deletar\n" +
                            "0 - Sair"
            );

            switch (opcao) {
                case 1 -> menuInserir();
                case 2 -> menuListar();
                case 3 -> menuAtualizar();
                case 4 -> menuDeletar();
                case 0 -> JOptionPane.showMessageDialog(null, "Encerrando o sistema...");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 0);
    }

    // ---------------- MENU INSERIR ----------------

    private static void menuInserir() throws SQLException, ClassNotFoundException {

        int opcao = inteiro(
                " >>>> MENU INSERIR <<<< \n" +
                        "1 - Usuário\n" +
                        "2 - Equipe\n" +
                        "3 - Funcionário\n" +
                        "4 - Tarefa\n" +
                        "5 - Conquista\n" +
                        "6 - Missão\n" +
                        "0 - Voltar"
        );

        switch (opcao) {
            case 1 -> inserirUsuario();
            case 2 -> inserirEquipe();
            case 3 -> inserirFuncionario();
            case 4 -> inserirTarefa();
            case 5 -> inserirConquista();
            case 6 -> inserirMissao();
        }
    }

    // ------------- INSERIR -------------

    private static void inserirUsuario() throws SQLException, ClassNotFoundException {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario u = new Usuario() {};

        u.setNome_usuario(texto("Nome do usuário:"));
        u.setEmail_usuario(texto("Email do usuário:"));

        JOptionPane.showMessageDialog(null, dao.inserir(u));
    }

    private static void inserirEquipe() throws SQLException, ClassNotFoundException {
        EquipeDAO dao = new EquipeDAO();
        Equipe e = new Equipe();

        e.setNome_equipe(texto("Nome da equipe:"));

        JOptionPane.showMessageDialog(null, dao.inserir(e));
    }

    private static void inserirFuncionario() throws SQLException, ClassNotFoundException {
        FuncionarioDAO dao = new FuncionarioDAO();
        Funcionario f = new Funcionario();

        f.setNome_funcionario(texto("Nome:"));
        f.setCargo_funcionario(texto("Cargo:"));
        f.setPontos_funcionario(inteiro("Pontos iniciais:"));
        f.setEmail_funcionario(texto("Email:"));
        f.setId_equipe(inteiro("ID da equipe:"));

        JOptionPane.showMessageDialog(null, dao.inserir(f));
    }

    private static void inserirTarefa() throws SQLException, ClassNotFoundException {
        TarefaDAO dao = new TarefaDAO();
        Tarefa t = new Tarefa();

        t.setDescricao_tarefa(texto("Descrição:"));
        t.setPontos_tarefa(inteiro("Pontos:"));
        t.setStatus_tarefa(texto("Status:"));
        t.setId_funcionario(inteiro("ID do funcionário:"));

        JOptionPane.showMessageDialog(null, dao.inserir(t));
    }

    private static void inserirConquista() throws SQLException, ClassNotFoundException {
        ConquistaDAO dao = new ConquistaDAO();
        Conquista c = new Conquista();

        c.setNome_conquista(texto("Nome da conquista:"));
        c.setCriterio_conquista(inteiro("Critério (pontos necessários):"));

        JOptionPane.showMessageDialog(null, dao.inserir(c));
    }

    private static void inserirMissao() throws SQLException, ClassNotFoundException {
        MissaoDAO dao = new MissaoDAO();
        Missao m = new Missao();

        m.setTitulo_missao(texto("Título da missão:"));
        m.setDescricao_missao(texto("Descrição da missão:"));
        m.setTipo_missao(texto("Tipo da missão:"));
        m.setXpRecompensa_missao(inteiro("XP de recompensa:"));

        JOptionPane.showMessageDialog(null, dao.inserir(m));
    }

    // ---------------- MENU LISTAR ----------------

    private static void menuListar() throws SQLException, ClassNotFoundException {

        int opcao = inteiro(
                " >>>> MENU LISTAR <<<< \n" +
                        "1 - Usuários\n" +
                        "2 - Equipes\n" +
                        "3 - Funcionários\n" +
                        "4 - Tarefas\n" +
                        "5 - Conquistas\n" +
                        "6 - Missões\n" +
                        "0 - Voltar"
        );

        switch (opcao) {
            case 1 -> listarUsuarios();
            case 2 -> listarEquipes();
            case 3 -> listarFuncionarios();
            case 4 -> listarTarefas();
            case 5 -> listarConquistas();
            case 6 -> listarMissoes();
        }
    }

    // ------------- LISTAR -------------

    private static void listarUsuarios() throws SQLException, ClassNotFoundException {
        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> lista = dao.listarTodos();

        StringBuilder sb = new StringBuilder("USUÁRIOS:\n\n");

        for (Usuario u : lista) {
            sb.append("ID: ").append(u.getId_usuario())
                    .append(" | Nome: ").append(u.getNome_usuario())
                    .append(" | Email: ").append(u.getEmail_usuario())
                    .append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void listarEquipes() throws SQLException, ClassNotFoundException {
        EquipeDAO dao = new EquipeDAO();
        List<Equipe> lista = dao.selecionar();

        StringBuilder sb = new StringBuilder("EQUIPES:\n\n");

        for (Equipe e : lista) {
            sb.append("ID: ").append(e.getId_equipe())
                    .append(" | Nome: ").append(e.getNome_equipe())
                    .append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void listarFuncionarios() throws SQLException, ClassNotFoundException {
        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> lista = dao.selecionar();

        StringBuilder sb = new StringBuilder("FUNCIONÁRIOS:\n\n");

        for (Funcionario f : lista) {
            sb.append("ID: ").append(f.getId_usuario())
                    .append(" | Nome: ").append(f.getNome_usuario())
                    .append(" | Cargo: ").append(f.getCargo_funcionario())
                    .append(" | Pontos: ").append(f.getPontos_funcionario())
                    .append(" | Email: ").append(f.getEmail_funcionario())
                    .append(" | Equipe: ").append(f.getId_equipe())
                    .append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void listarTarefas() throws SQLException, ClassNotFoundException {
        TarefaDAO dao = new TarefaDAO();
        List<Tarefa> lista = dao.selecionar();

        StringBuilder sb = new StringBuilder("TAREFAS:\n\n");

        for (Tarefa t : lista) {
            sb.append("ID: ").append(t.getId_tarefa())
                    .append(" | Desc: ").append(t.getDescricao_tarefa())
                    .append(" | Pontos: ").append(t.getPontos_tarefa())
                    .append(" | Status: ").append(t.getStatus_tarefa())
                    .append(" | Data_Fim").append(t.getData_fim_tarefa())
                    .append(" | Funcionário: ").append(t.getId_funcionario())
                    .append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void listarConquistas() throws SQLException, ClassNotFoundException {
        ConquistaDAO dao = new ConquistaDAO();
        List<Conquista> lista = dao.selecionar();

        StringBuilder sb = new StringBuilder("CONQUISTAS:\n\n");

        for (Conquista c : lista) {
            sb.append("ID: ").append(c.getId_consquista())
                    .append(" | Nome: ").append(c.getNome_conquista())
                    .append(" | Critério: ").append(c.getCriterio_conquista())
                    .append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void listarMissoes() throws SQLException, ClassNotFoundException {
        MissaoDAO dao = new MissaoDAO();
        List<Missao> lista = dao.selecionar();

        StringBuilder sb = new StringBuilder("MISSÕES:\n\n");

        for (Missao m : lista) {
            sb.append("ID: ").append(m.getId_missao())
                    .append(" | Título: ").append(m.getTitulo_missao())
                    .append(" | Descrição: ").append(m.getDescricao_missao())
                    .append(" | Tipo: ").append(m.getTipo_missao())
                    .append(" | XP: ").append(m.getXpRecompensa_missao())
                    .append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    // ---------------- MENU ATUALIZAR ----------------

    private static void menuAtualizar() throws SQLException, ClassNotFoundException {

        int opcao = inteiro(
                " >>>> MENU ATUALIZAR <<<< \n" +
                        "1 - Usuário\n" +
                        "2 - Equipe\n" +
                        "3 - Funcionário\n" +
                        "4 - Tarefa\n" +
                        "5 - Conquista\n" +
                        "6 - Missão\n" +
                        "0 - Voltar"
        );

        switch (opcao) {
            case 1 -> atualizarUsuario();
            case 2 -> atualizarEquipe();
            case 3 -> atualizarFuncionario();
            case 4 -> atualizarTarefa();
            case 5 -> atualizarConquista();
            case 6 -> atualizarMissao();
        }
    }

    // ------------- ATUALIZAR -------------

    private static void atualizarUsuario() throws SQLException, ClassNotFoundException {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario u = new Usuario() {};

        u.setId_usuario(inteiro("ID do usuário:"));
        u.setNome_usuario(texto("Novo nome:"));
        u.setEmail_usuario(texto("Novo email:"));

        JOptionPane.showMessageDialog(null, dao.atualizar(u));
    }

    private static void atualizarEquipe() throws SQLException, ClassNotFoundException {
        EquipeDAO dao = new EquipeDAO();
        Equipe e = new Equipe();

        e.setId_equipe(inteiro("ID da equipe:"));
        e.setNome_equipe(texto("Novo nome da equipe:"));

        JOptionPane.showMessageDialog(null, dao.atualizar(e));
    }

    private static void atualizarFuncionario() throws SQLException, ClassNotFoundException {
        FuncionarioDAO dao = new FuncionarioDAO();
        Funcionario f = new Funcionario();

        f.setId_usuario(inteiro("ID do funcionário:"));
        f.setNome_funcionario(texto("Novo nome:"));
        f.setCargo_funcionario(texto("Novo cargo:"));
        f.setPontos_funcionario(inteiro("Nova pontuação:"));
        f.setEmail_funcionario(texto("Novo email:"));
        f.setId_equipe(inteiro("Novo ID da equipe:"));

        JOptionPane.showMessageDialog(null, dao.atualizar(f));
    }

    private static void atualizarTarefa() throws SQLException, ClassNotFoundException {
        TarefaDAO dao = new TarefaDAO();
        Tarefa t = new Tarefa();

        t.setId_tarefa(inteiro("ID da tarefa:"));
        t.setDescricao_tarefa(texto("Nova descrição:"));
        t.setPontos_tarefa(inteiro("Novos pontos:"));
        t.setStatus_tarefa(texto("Novo status:"));
        t.setData_fim_tarefa(texto("Nova data fim:"));
        t.setId_funcionario(inteiro("Novo ID do funcionário:"));

        JOptionPane.showMessageDialog(null, dao.atualizar(t));
    }

    private static void atualizarConquista() throws SQLException, ClassNotFoundException {
        ConquistaDAO dao = new ConquistaDAO();
        Conquista c = new Conquista();

        c.setId_consquista(inteiro("ID da conquista:"));
        c.setNome_conquista(texto("Novo nome:"));
        c.setCriterio_conquista(inteiro("Novo critério:"));

        JOptionPane.showMessageDialog(null, dao.atualizar(c));
    }

    private static void atualizarMissao() throws SQLException, ClassNotFoundException {
        MissaoDAO dao = new MissaoDAO();
        Missao m = new Missao();

        m.setId_missao(inteiro("ID da missão:"));
        m.setTitulo_missao(texto("Novo título:"));
        m.setDescricao_missao(texto("Nova descrição:"));
        m.setTipo_missao(texto("Novo tipo:"));
        m.setXpRecompensa_missao(inteiro("Nova recompensa XP:"));

        JOptionPane.showMessageDialog(null, dao.atualizar(m));
    }

    // ---------------- MENU DELETAR ----------------

    private static void menuDeletar() throws SQLException, ClassNotFoundException {

        int opcao = inteiro(
                " >>>> MENU DELETAR <<<< \n" +
                        "1 - Usuário\n" +
                        "2 - Equipe\n" +
                        "3 - Funcionário\n" +
                        "4 - Tarefa\n" +
                        "5 - Conquista\n" +
                        "6 - Missão\n" +
                        "0 - Voltar"
        );

        switch (opcao) {
            case 1 -> deletarUsuario();
            case 2 -> deletarEquipe();
            case 3 -> deletarFuncionario();
            case 4 -> deletarTarefa();
            case 5 -> deletarConquista();
            case 6 -> deletarMissao();
        }
    }

    // ------------- DELETAR -------------

    private static void deletarUsuario() throws SQLException, ClassNotFoundException {
        UsuarioDAO dao = new UsuarioDAO();
        int id = inteiro("ID do usuário:");
        JOptionPane.showMessageDialog(null, dao.deletar(id));
    }

    private static void deletarEquipe() throws SQLException, ClassNotFoundException {
        EquipeDAO dao = new EquipeDAO();
        int id = inteiro("ID da equipe:");
        JOptionPane.showMessageDialog(null, dao.deletar(id));
    }

    private static void deletarFuncionario() throws SQLException, ClassNotFoundException {
        FuncionarioDAO dao = new FuncionarioDAO();
        int id = inteiro("ID do funcionário:");
        JOptionPane.showMessageDialog(null, dao.deletar(id));
    }

    private static void deletarTarefa() throws SQLException, ClassNotFoundException {
        TarefaDAO dao = new TarefaDAO();
        int id = inteiro("ID da tarefa:");
        JOptionPane.showMessageDialog(null, dao.deletar(id));
    }

    private static void deletarConquista() throws SQLException, ClassNotFoundException {
        ConquistaDAO dao = new ConquistaDAO();
        int id = inteiro("ID da conquista:");
        JOptionPane.showMessageDialog(null, dao.deletar(id));
    }

    private static void deletarMissao() throws SQLException, ClassNotFoundException {
        MissaoDAO dao = new MissaoDAO();
        int id = inteiro("ID da missão:");
        JOptionPane.showMessageDialog(null, dao.deletar(id));
    }
}
