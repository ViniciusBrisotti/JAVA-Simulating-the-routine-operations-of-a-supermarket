package FormaPagamento;

public class CartaoDebito {

    //Variaveis públicas da classe
    public String numeroBanco, numeroAgencia, contaCorrente;

    //Construtor da classe, que recebe três parametros(numero do banco, numero da agencia e conta corrente)
    public CartaoDebito(String numeroBanco, String numeroAgencia, String contaCorrente) {

        this.numeroBanco = numeroBanco;
        this.numeroAgencia = numeroAgencia;
        this.contaCorrente = contaCorrente;

    }

    //método que define o numero da conta corrente
    public void definirNumeroContaCorrente(String contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    //método que define o numero do banco
    public void DefineNumeroBanco(String num) {
        numeroBanco = num;
    }

    //método que define o numero da agencia
    public void DefineNumeroAgencia(String num) {
        numeroAgencia = num;
    }

}
