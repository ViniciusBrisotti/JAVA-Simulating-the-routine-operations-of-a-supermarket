package Usuarios;

public class Funcionario {

    //Variaveis da classe
    protected String nome, cargo, matricula;

    //construtor que define as variaveis da classe com parametros
    public Funcionario(String nome, String cargo, String matricula) {
        this.cargo = cargo;
        this.matricula = matricula;
        this.nome = nome;
    }

}
