package Loja;

import FormaPagamento.CartaoCredito;
import FormaPagamento.CartaoDebito;
import FormaPagamento.Cheque;
import java.util.ArrayList;
import java.util.Scanner;

public class Caixa {

    //lista de cheques aonde serão adicionados objetos da classe Cheque
    ArrayList<Cheque> cheques;
    //lista de produtos aonde serão adicionados objetos da classe Produto
    ArrayList<Produto> listaProduto;
    //Preço total da compra
    public double precoTotal;
    //strings de cpf e cnpj do cliente, forma de pagamento(define o método de pagamento),
    //numero do banco,e conta corrente(para cartão de débito) nome da administradora e numero do cartão(para cartão de crédito)
    String cpfCliente, cnpjCliente, formaDePagamento, numeroBanco, contaCorrente, nomeAdministradora, numerocartao;
    //Numero de parcelas para o cartão de crédito
    int numeroParcelas;
    //boolean que define se o valor do dinheiro oferecido é o suficiente para efetuar a compra
    public boolean valorSuficiente;

    //Construtor da classe
    public Caixa() {
        valorSuficiente = false;
        cheques = new ArrayList<>();
    }
    
    //Método que retorna o preco total da compra
    public double RetornaPrecoPagar(ArrayList<Produto> lp) {

        listaProduto = lp;
        precoTotal = 0;

        for (int i = 0; i < listaProduto.size(); i++) {

            setPrecoTotal(listaProduto.get(i));
        }

        return precoTotal;
        //System.out.println("O preço é registrado!");
    }
    
    //Método que define o preco total da compra
    void setPrecoTotal(Produto p) {
        precoTotal += p.preco;
    }
    
    //Método que efetua o pagamento em dinheiro
    public double pagamentoDinheiro(double valor) {

        double Troco;
        if (precoTotal > valor) {
            System.out.println("Dinheiro insuficiente");
            valorSuficiente = false;
            return valor;
        } else {
            Troco = valor - precoTotal;
            System.out.println("Valor do troco: " + Troco);
            valorSuficiente = true;
            return Troco;
        }

    }

   //Método que adiciona um ojeto da classe Cheque na lista de Cheques
    public void recebeCheque(Cheque ch) {
        cheques.add(ch);
    }

    //Método que efetua o pagamento em cartão de crédito ao receber um objeto da Classe CartaoCredito como parâmetro
    public void recebeCartaoCredito(CartaoCredito cartaoCredito) {
        boolean transacaoAprovada = false;
        System.out.println("A quantia a ser paga é de " + precoTotal);
        while (!transacaoAprovada) {
            System.out.println("Seguem as informações do cartão: ");
            System.out.println(cartaoCredito.BandeiraCartao);
            System.out.println(cartaoCredito.numeroCartao);
            System.out.println(cartaoCredito.parcelas);
            System.out.println("As informacoes estão certas?");
            Scanner sc = new Scanner(System.in);
            String input = sc.next();
            if (input.equals("Sim") || input.equals("sim") || input.equals("s")) {
                System.out.println("Entre com as informações corretas da Bandeira: ");
                cartaoCredito.DefineBandeira(sc.next());
                System.out.println("Entre com as informações corretas do numero do cartão: ");
                cartaoCredito.DefineNumeroCartao(sc.next());
                System.out.println("Entre com a quantidade de parcelas: ");
                cartaoCredito.definirNumeroParcelas(sc.nextInt());
            } else {
                nomeAdministradora = cartaoCredito.BandeiraCartao;
                numerocartao = cartaoCredito.numeroCartao;
                numeroParcelas = cartaoCredito.parcelas;

                System.out.println("Transação concluida.");
                transacaoAprovada = true;
            }

        }

    }

    //Método que efetua o pagamento em cartão de débito ao receber um objeto da Classe CartaoDebito como parâmetro
    public void recebeCartaoDebito(CartaoDebito cartaoDebito) {
        boolean transacaoAprovada = false;
        System.out.println("A quantia a ser paga é de " + precoTotal);
        while (!transacaoAprovada) {
            System.out.println("Seguem as informações do cartão: ");
            System.out.println(cartaoDebito.numeroBanco);
            System.out.println(cartaoDebito.numeroAgencia);
            System.out.println(cartaoDebito.contaCorrente);
            System.out.println("As informacoes estão certas?");
            Scanner sc = new Scanner(System.in);
            String input = sc.next();
            if (input.equals("Sim") || input.equals("sim") || input.equals("s")) {
                System.out.println("Entre com o numero do banco: ");
                cartaoDebito.DefineNumeroBanco(sc.next());
                System.out.println("Entre com numero da agencia: ");
                cartaoDebito.DefineNumeroAgencia(sc.next());
                System.out.println("Entre com o numero da conta corrente: ");
                cartaoDebito.definirNumeroContaCorrente(sc.next());
            } else {
                numeroBanco = cartaoDebito.numeroBanco;
                contaCorrente = cartaoDebito.contaCorrente;
                System.out.println("Transação concluida.");
                transacaoAprovada = true;
            }

        }

    }

    //Método que define os valores de CPF e CNPJ por meio de parâmetros
    public void RegistraCPF_CNPJ(String CPF, String CNPJ) {
        cpfCliente = CPF;
        cnpjCliente = CNPJ;
    }

    //Método que define o método de pagamento por meio de uma string como parametro
    public void RegistraFormaPagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    //Método que exibe a nota fiscal com os detalhes da compra na tela
    public String emiteNotaFiscal() {
        String notaFiscal = "Cupom Fiscal.\n";

        notaFiscal += "Marinos Comércio Ltda.\n";
        notaFiscal += "Rua dos Milagres, 391 – Vila Grande – CEP: 03921-036 – Ubirajara.\n";
        notaFiscal += "CNPJ: 11.341.667/0001-21\n";
        if (!cpfCliente.equals("")) {
            notaFiscal += "CPF: " + cpfCliente + "\n";
        }
        if (!cnpjCliente.equals("")) {
            notaFiscal += "CNPJ " + cnpjCliente + "\n";
        }
        notaFiscal += "Forma de pagamento:\n";
        if (formaDePagamento.equals("Cartao de Débito")) {
            notaFiscal += formaDePagamento + ":\n Numero do banco: " + numeroBanco + ".\nNumero da Conta Corrente: " + contaCorrente + ".\n";
        } else if (formaDePagamento.equals("Cartao de Crédito")) {
            notaFiscal += formaDePagamento + ":\nNome da administradora: " + nomeAdministradora + ".\nNúmero do cartão:" + numerocartao + ".\nNumero de parcelas: " + numeroParcelas + ".";
        }
        notaFiscal += "Valor Total da compra: " + precoTotal;
        return notaFiscal;
    }

}
