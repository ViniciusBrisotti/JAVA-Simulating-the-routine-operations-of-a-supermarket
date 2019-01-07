package FormaPagamento;

public class CartaoCredito {

    //Variaveis públicas da classe
    public String BandeiraCartao, numeroCartao;
    public int parcelas;

    //Construtor da classe, que recebe dois parametros(bandeira do cartao e numero do cartao)
    public CartaoCredito(String BandeiraCartao, String numeroCartao) {
        this.BandeiraCartao = BandeiraCartao;
        this.numeroCartao = numeroCartao;
    }

    //método que define o numero de parcelas da compra
    public void definirNumeroParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    //método que define a bandeira do cartão
    public void DefineBandeira(String bn) {
        BandeiraCartao = bn;
    }
    
    //método que define o número do cartão
    public void DefineNumeroCartao(String num) {
        numeroCartao = num;
    }

}
