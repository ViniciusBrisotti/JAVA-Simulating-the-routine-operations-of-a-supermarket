package MainMercado;

import Usuarios.Cliente;
import Loja.Loja;



public class MainClass {

    public static void main(String[] args) {
        //clsse principal
        //instancia o objeto do cliente
        Cliente c = new Cliente("Fulano");
        //instancia o objeto da loja
        Loja loja = new Loja();
        //adiciona itens do tipo produto na lista de produtos classe cliente pela classe da loja
        loja.clienteSomaNaListadeProdutos(c);
        //entrega os produtos para o atendente
        loja.atendenteEscolhidoRecebeProduto(c);
        //determina o metodo de pagamento
        loja.InsiraMetodoPagamento(c);
        //metodo de checar por cpf ou cnpj do cliente
        loja.NotaFiscalCPF_CNPJ(c);
        //Exibe a nota fiscal
        System.out.println(loja.EmiteNotaFiscal());
        //mensagem de conclusão
        System.out.println("\n\nTransação concluída. Volte sempre.");
    }
    
    
}
