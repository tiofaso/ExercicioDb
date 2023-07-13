package model;

//Tabela do nosso banco
public class UsuarioModel {

    //Atributos = Colunas do banco

    private int id_usuario;
    private String nome;

    public UsuarioModel(int id_usuario, String nome) {
        this.id_usuario = id_usuario;
        this.nome = nome;
    }

    public UsuarioModel() {}

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
