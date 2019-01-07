package Usuarios;

import FormaPagamento.Cheque;
import Loja.Produto;
import Loja.Caixa;
import java.util.ArrayList;
import java.util.Scanner;

public class Atendente extends Funcionario {

    //Varaiveis da classe
    Cliente cliente;
    public boolean estaOcupada;
    public int senhacaixa;
    ArrayList<Produto> produtosDoCliente;
    Caixa caixa;
    double precoPagar;

    //construtor que defeine as variaveis da classe com parametros
    public Atendente(String nome, String cargo, String matricula, boolean ocupada) {

        super(nome, cargo, matricula);
        estaOcupada = ocupada;
        senhacaixa = 0000;
        precoPagar = 0;
        caixa = new Caixa();
        cargo = "Atendente";
    }

    //Método que define a va lista de produtod do cliente
    public void recebeProdutos(Cliente c) {
        produtosDoCliente = c.lista;
        registraProduto();
    }

    //Registra os produtos
    void registraProduto() {

        if (produtosDoCliente != null) {
            System.out.println("O atendente passa os produtos no caixa!");
            precoPagar = caixa.RetornaPrecoPagar(produtosDoCliente);
            System.out.println("O preco a pagar é de " + precoPagar);
        } else {
            System.out.println("Não possuem produtos para serem registrados!");
        }

    }

    //Pergunta qual o método de pagamento
    public void definePagamento(Cliente cliente) {
        boolean t = true;
        while (t) {
            System.out.println("Defina o método de pagamento:");
            System.out.println("Insira 1 para cartão de débito.");
            System.out.println("Insira 2 para cartão de crédito.");
            System.out.println("Insira 3 para cheque.");
            System.out.println("Insira 4 para dinheiro.");

            Scanner c = new Scanner(System.in);
            int input = c.nextInt();
            switch (input) {
                case 1:
                    caixa.RegistraFormaPagamento("Cartao de Débito");
                    caixa.recebeCartaoDebito(cliente.debito);
                    t = false;
                    break;
                case 2:
                    caixa.RegistraFormaPagamento("Cartao de Crédito");
                    caixa.recebeCartaoCredito(cliente.credito);
                    t = false;
                    break;
                case 3:
                    caixa.RegistraFormaPagamento("Cheque");
                    Cheque cheque = cliente.escreveCheque("1234", "01", "012322", "092834093", cliente.nome);
                    cheque.DefineValorCheque(precoPagar);
                    caixa.recebeCheque(cheque);
                    t = false;
                    break;
                case 4:
                    caixa.RegistraFormaPagamento("Dinheiro");
                    System.out.println("Entre com o valor em dinheiro que irá entregar ao caixa:");
                    double valorDinheiro = new Scanner(System.in).nextDouble();
                    cliente.saldoDinheiro = caixa.pagamentoDinheiro(valorDinheiro);
                    System.out.println(caixa.precoTotal);
                    System.out.println(valorDinheiro);
                    if (caixa.valorSuficiente) {
                        t = false;
                        break;
                    } else {
                        t = true;
                        break;
                    }
                default:
                    System.out.println("valor invalido");
                    break;
            }

        }
    }

    //Define se vai  inserir o CPF/CNPJ na nota fiscal
    public void RegistraDadosNotaFiscal(Cliente c) {
        System.out.println("Deseja inserir o seu CPF ou CNPJ na nota fiscal?");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        
        if (input.equals("Sim") || input.equals("sim") || input.equals("s")) {
            boolean t = true;
            while (t) {
                System.out.println("Insira 'CPF' caso queira inserir o seu cpf ou 'CNPJ' caso queira inserir o CNPJ da sua empresa");
                Scanner scanner = new Scanner(System.in);
                String opcao = scanner.next();
                if (opcao.equals("cpf") || opcao.equals("CPF")) {
                    System.out.println("Entre com o seu CPF: ");
                    CPF(c, sc);
                    c.CNPJ = "";
                    t = false;
                } else if (opcao.equals("cnpj") || opcao.equals("CNPJ")) {
                    System.out.println("Entre com o seu CNPJ: ");
                    CNPJ(c, sc);
                    c.CPF = "";
                    t = false;
                }
            }

        } else {
            c.CNPJ = "";
            c.CPF = "";
        }
        caixa.RegistraCPF_CNPJ(c.CPF, c.CNPJ);
    }

    //Define o valor do CPF
    void CPF(Cliente c, Scanner sc) {
        c.CPF = sc.next();
    }

    //Define o valor do CNPJ
    void CNPJ(Cliente c, Scanner sc) {
        c.CNPJ = sc.next();
    }

    //Retorna a nota fiscal
    public String EmiteNotaFiscal() {
        return caixa.emiteNotaFiscal();
    }

}
