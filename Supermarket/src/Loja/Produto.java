package Loja;

public class Produto {

    //variaveis do preço, nome e código do produto
    double preco;
    String nome;
    public String codigo;

    //Contrutor da classe que define as variaveis locais por meio de parametros
    public Produto(double preco, String nome, String codigo) {
        this.preco = preco;
        this.nome = nome;
        this.codigo = codigo;
    }

}
