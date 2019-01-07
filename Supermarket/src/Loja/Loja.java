package Loja;

import Usuarios.Atendente;
import Usuarios.Cliente;
import java.util.Scanner;

public class Loja {
    
    //variavel definindo numero de atendentes
    int numeroAtendentes = 4;
   //Variavel do tipo Catalogo
    Catalogo catalogo;
    //Array de atendentes
    Atendente[] funcionarios;
    //Variavel do tipo Atendente que será a atendente escolhida que fara o atendimento no caixa
    Atendente atendenteEscolhido;
    
    //Construtor da classe que seta os valores na array de atendentes e o atendente escolhido
    public Loja() {
        catalogo = new Catalogo();
        funcionarios = new Atendente[numeroAtendentes];
        funcionarios[0] = new Atendente("Fulana", "Atendente", "1230", false);
        funcionarios[1] = new Atendente("Beltrana", "Atendente", "0234", false);
        funcionarios[2] = new Atendente("Cicrana", "Atendente", "1034", false);
        funcionarios[3] = new Atendente("Carla", "Atendente", "1204", false);
        
        for (int i = 0; i < funcionarios.length; i++) {
            if (!funcionarios[i].estaOcupada) {
                atendenteEscolhido = funcionarios[i];
                atendenteEscolhido.estaOcupada = true;
                break;
            }
        }
    }
    
    //Método que soma os produtos na lista de produtos
    public void clienteSomaNaListadeProdutos(Cliente cliente) {
        System.out.println("Bem vindo a loja. Inclua seus produtos na lista.");
        int limiteIndex = catalogo.produtos.size();
        
        while (true) {
            System.out.println("Entre com um valor: \nClique entre 0 e " + limiteIndex + " para adicionar os produtos do catalogo da Loja. \nOu pressione -1 para sair.");
            
            Scanner c = new Scanner(System.in);
            int input = c.nextInt();
            if (input <= -1) {
                System.out.println("O Cliente parou de adicionar ao carrinho!");
                System.out.println("Hora de ir ao caixa!");
                break;
            } else {
                System.out.println("Insira os produtos na lista!");
                
                if (input < 0 || input >= catalogo.produtos.size()) {
                    System.out.println("Valor inválido");
                } else {
                  
                    cliente.AdicionaListaCliente(catalogo.getProduct(input));
                }
                
            }
        }
    }
    
    //Atendente escolhido recebe os produtos do cliente 
    public void atendenteEscolhidoRecebeProduto(Cliente c) {
        atendenteEscolhido.recebeProdutos(c);
    }
    
    //Definir o método de pagamento
    public void InsiraMetodoPagamento(Cliente c) {
        atendenteEscolhido.definePagamento(c);
        
    }
    
    //Registra os dados da nota fiscal
    public void NotaFiscalCPF_CNPJ(Cliente c) {
        atendenteEscolhido.RegistraDadosNotaFiscal(c);
    }
    
    //exibe os dados da nota fiscal
    public String EmiteNotaFiscal(){
        return atendenteEscolhido.EmiteNotaFiscal();
    }
    
}
