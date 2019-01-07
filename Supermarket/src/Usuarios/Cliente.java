package Usuarios;

import FormaPagamento.CartaoCredito;
import FormaPagamento.CartaoDebito;
import Loja.Produto;
import FormaPagamento.Cheque;
import java.util.ArrayList;

public class Cliente {

    //Varaiveis da classe
    public String banco;
    public String bancoCheque, serieCheque, contaCorrente, numeroCheque, nomeComprador;
    public String BandeiraCartao, numeroCartao;
    int parcelascaartaoDebito;
    public CartaoCredito credito;
    public CartaoDebito debito;
    public String CPF, CNPJ;
    public double saldoDinheiro;
    String nome;
    public ArrayList<Produto> lista;

    //construtor que define as variaveis da classe com parametros
    public Cliente(String nome) {
        this.nome = nome;
        saldoDinheiro = 0;
        lista = new ArrayList();
        credito = new CartaoCredito("Mastercard","13212-3");
        debito = new CartaoDebito("1234", "43234", "012322");
    }

    //recebe parametro
    public void AdicionaListaCliente(Produto p) {
        if (lista != null) {
            lista.add(p);
        }
    }

    //metodo de retornar cpf
    public String getCPF(){
        return this.CPF;
    }
    
    //retorna produto da lista
    public Produto getProduto(int indice) {
        return lista.get(indice);
    }

    //retorna um objeto da classe cheque com os dados passados como parametro
    public Cheque escreveCheque(String bancoCheque,String serieCheque,String contaCorrente, String numeroCheque, String nomeComprador){
        return new Cheque(bancoCheque, serieCheque, contaCorrente, numeroCheque, nomeComprador);
    }
    
    
    
}
