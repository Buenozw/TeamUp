package br.com.fiap.beans;

public class Conquista {

    private int id_consquista;
    private String nome_conquista;
    private int criterio_conquista;

    // Metodo Contrutor

    public Conquista() {
    }

    // Getters e Setters
    public int getId_consquista() {
        return id_consquista;
    }

    public void setId_consquista(int id_consquista) {
        this.id_consquista = id_consquista;
    }

    public String getNome_conquista() {
        return nome_conquista;
    }

    public void setNome_conquista(String nome_conquista) {
        this.nome_conquista = nome_conquista;
    }

    public int getCriterio_conquista() {
        return criterio_conquista;
    }

    public void setCriterio_conquista(int criterio_conquista) {
        this.criterio_conquista = criterio_conquista;
    }
}
