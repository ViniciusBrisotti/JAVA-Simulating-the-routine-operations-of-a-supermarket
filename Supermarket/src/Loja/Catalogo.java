package Loja;

import java.util.ArrayList;

public class Catalogo {

    //Lista de objetos da classe de Produto
    public ArrayList<Produto> produtos;

    //Construtor que adiciona objetos da classe Produto na lista de produtos
    public Catalogo() {
        produtos = new ArrayList();
        produtos.add(new Produto(2.99, "Produto1", "1"));
        produtos.add(new Produto(10.99, "Produto2", "2"));
        produtos.add(new Produto(2.99, "Produto3", "3"));
        produtos.add(new Produto(3.99, "Produto4", "4"));
        produtos.add(new Produto(12.99, "Produto5", "5"));
        produtos.add(new Produto(23.99, "Produto6", "6"));
        produtos.add(new Produto(2.99, "Produto7", "7"));
        produtos.add(new Produto(6.99, "Produto8", "8"));
        produtos.add(new Produto(5.50, "Produto9", "9"));
        produtos.add(new Produto(2.99, "Produto10", "10"));
        produtos.add(new Produto(1.00, "Produto11", "11"));

    }

    //Método que retorna um objeto na lista de produtos pelo indice com o parametro index
    public Produto getProduct(int index) {
        return produtos.get(index);
    }

}
