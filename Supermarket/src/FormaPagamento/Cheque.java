package FormaPagamento;

public class Cheque {

    //Variaveis públicas da classe
    public String bancoCheque, serieCheque, contaCorrente, numeroCheque, nomeComprador;
    public double valor;

    //Construtor da classe, que recebe dois parametros(serieCheque, contaCorrente, numeroCheque e nomeComprador)
    public Cheque(String bancoCheque, String serieCheque, String contaCorrente, String numeroCheque, String nomeComprador) {

        this.bancoCheque = bancoCheque;
        this.contaCorrente = contaCorrente;
        this.nomeComprador = nomeComprador;
        this.serieCheque = serieCheque;
    }

    //método que define o valor do cheque
    public void DefineValorCheque(double valor) {
        this.valor = valor;
    }

}
