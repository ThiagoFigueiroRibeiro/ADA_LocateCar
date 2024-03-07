package Model;

import java.util.Scanner;

public class Menu{
    ListaDeVeiculos listaDeVeiculos;
    ListaDeClientes listaDeClientes;

    public Menu(ListaDeVeiculos listaDeVeiculos, ListaDeClientes listaDeClientes) {
        this.listaDeVeiculos = listaDeVeiculos;
        this.listaDeClientes = listaDeClientes;
    }

    void Opcoes(){
        Scanner keys = new Scanner(System.in);
        int escolha = keys.nextInt();
        switch (escolha){
            case 1:
                AdicionarCliente();
                break;
            case 2:
                ExibirClientes();
                break;
            case 3:
                AdicionarCarro();
                break;
            case 4:
                ExibirCarros();
                break;
            case 5:
                //AlugarVeiculo();
                break;
            case 6:
                //DevolverCarro();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Escolha uma das opções abaixo");

        }
    }
    public void ExibirMenu() {
        System.out.println("LocateCar: Menu principal");
        while(true){
            System.out.println("Escolha uma opção abaixo: ");
            System.out.println("1 - Adicionar Cliente");
            System.out.println("2 - Exibir lista de Clientes");
            System.out.println("3 - Adicionar Carro");
            System.out.println("4 - Exibir Lista de Carros");
            System.out.println("5 - Alugar Carro");
            System.out.println("6 - Devolver Carro");
            System.out.println("0 - Sair do programa");
            Opcoes();
        }
    }

    void AdicionarCliente(){
        Scanner keyAdicionarCliente = new Scanner(System.in);
        System.out.println("Você deseja inscrever CPF (1) ou CNPJ (2)?");
        int escolha = keyAdicionarCliente.nextInt();
        switch (escolha){
            case 1: {
                System.out.println("Qual é o nome do cliente?");
                Scanner nomeCliente = new Scanner(System.in);
                String nome = nomeCliente.nextLine();
                System.out.println("Qual é o CPF do cliente?");
                Scanner cpfCliente = new Scanner(System.in);
                int cpf = cpfCliente.nextInt();
                new Cliente(nome, TipoCliente.CPF, cpf, listaDeClientes);
                break;
            }
            case 2: {
                System.out.println("Qual é o nome da empresa?");
                Scanner nomeCliente = new Scanner(System.in);
                String nome = nomeCliente.nextLine();
                System.out.println("Qual é o CNPJ da empresa?");
                Scanner cnpjCliente = new Scanner(System.in);
                int cnpj = cnpjCliente.nextInt();
                new Cliente(nome, TipoCliente.CNPJ, cnpj, listaDeClientes);
                break;
            }
            default:
        }
    }
    void ExibirClientes(){}
    void AdicionarCarro(){
        Veiculo Corsa = new Veiculo(TipoVeiculo.PEQUENO, "ABC-1234", listaDeVeiculos);
    }
    void ExibirCarros(){
        System.out.println("Mostrando Veiculos:");
        listaDeVeiculos.MostrarVeiculos();
    }
    void PesquisarCarro(){listaDeVeiculos.ProcurarVeiculo("ABC");}
    //void AlugarVeiculo(){ServicoDeAluguel.AlugarVeiculo(Corsa, thiago);};
    //void DevolverCarro(){ServicoDeAluguel.DevolverVeiculo(Corsa, thiago);}

    public void Tutorial(){
        Veiculo Corsa = new Veiculo(TipoVeiculo.PEQUENO, "ABC-1234", listaDeVeiculos);
        Veiculo Corsa2 = new Veiculo(TipoVeiculo.MEDIO, "ABC-4321", listaDeVeiculos);
        Cliente thiago = new Cliente("Thiago", TipoCliente.CPF, 56666332, listaDeClientes);
        Cliente thiago2 = new Cliente("Thiago", TipoCliente.CPF, 56666332, listaDeClientes);

        System.out.println("Mostrando Veiculos:");
        listaDeVeiculos.MostrarVeiculos();

        listaDeVeiculos.ProcurarVeiculo("ABC");

        System.out.println("Alugando para o cliente Thiago");
        ServicoDeAluguel.AlugarVeiculo(Corsa, thiago);
        ServicoDeAluguel.DevolverVeiculo(Corsa, thiago);
    }

}
