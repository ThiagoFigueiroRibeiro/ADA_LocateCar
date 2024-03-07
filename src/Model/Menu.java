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
                AlugarVeiculo();
                break;
            case 6:
                DevolverCarro();
                break;
            case 7:
                PesquisarCarro();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Escolha uma das opções abaixo");

        }
    }
    public void ExibirMenu() {
        System.out.println("LocateCar: Menu principal");
        while (true) {
            System.out.println("Escolha uma opção abaixo: ");
            System.out.println("1 - Adicionar Cliente");
            System.out.println("2 - Exibir lista de Clientes");
            System.out.println("3 - Adicionar Carro");
            System.out.println("4 - Exibir Lista de Carros");
            System.out.println("5 - Alugar Carro");
            System.out.println("6 - Devolver Carro");
            System.out.println("7 - Pesquisar Carro");
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
    void ExibirClientes(){
        System.out.println("Mostrando Clientes:");
        listaDeClientes.MostrarClientes();
    }
    void AdicionarCarro(){
        Scanner keyAdicionarCarro = new Scanner(System.in);
        System.out.println("Qual tipo de carro você quer adicionar?");
        System.out.println("1 - Pequeno");
        System.out.println("2 - Medio");
        System.out.println("3 - SUV");
        TipoVeiculo tipo = null;
        int escolha = keyAdicionarCarro.nextInt();
        switch (escolha){
            case 1: {
                tipo = TipoVeiculo.PEQUENO;
                break;
            }
            case 2: {
                tipo = TipoVeiculo.MEDIO;
                break;
            }
            case 3: {
                tipo = TipoVeiculo.SUV;
                break;
            }
            default:
        }
        System.out.println("Qual é a placa do carro?");
        Scanner keyAdicionarPlaca = new Scanner(System.in);
        String placa = keyAdicionarPlaca.nextLine();
        new Veiculo(tipo, placa, listaDeVeiculos);
    }
    void ExibirCarros(){
        System.out.println("Mostrando Veiculos:");
        listaDeVeiculos.MostrarVeiculos();
    }
    void PesquisarCarro(){
        System.out.println("Qual é a placa do carro que você quer procurar?");
        Scanner keyProcurarCarro = new Scanner(System.in);
        String placa = keyProcurarCarro.nextLine();
        listaDeVeiculos.ProcurarVeiculo(placa);}
    void AlugarVeiculo(){
        if (!listaDeVeiculos.lista.isEmpty() && !listaDeClientes.lista.isEmpty()){
            boolean carroExiste = false;
            boolean clienteExiste = false;
            System.out.println("Qual é a placa do carro que você quer alugar?");
            Scanner keyProcurarCarro = new Scanner(System.in);
            String placa = keyProcurarCarro.nextLine();
            Veiculo veiculo = (Veiculo) listaDeVeiculos.lista.getFirst(); // Gambiarra da forte

            System.out.println("Qual é o CPF/CNPJ do cliente que quer alugar?");
            Scanner keyProcurarNI = new Scanner(System.in);
            int NI = keyProcurarNI.nextInt();
            Cliente cliente = (Cliente) listaDeClientes.lista.getFirst(); // Gambiarra da forte

            for(Object V: listaDeVeiculos.lista){
                Veiculo esteCarro = (Veiculo) V;
                if (esteCarro.getPlaca().equals(placa)){
                    veiculo = esteCarro;
                    carroExiste = true;
                    break;
                }
            }

            for(Object K: listaDeClientes.lista){
                Cliente esteCliente = (Cliente) K;
                if (esteCliente.getNumeroIdentificador()==NI){
                    cliente = esteCliente;
                    clienteExiste = true;
                    break;
                }
            }
            if (carroExiste&&clienteExiste){
                if(veiculo.estaAlugado) {
                    System.out.println("Esse veículo já está alugado.");
                }
                else {
                    ServicoDeAluguel.AlugarVeiculo(veiculo, cliente);
                }
            }
            else {
                System.out.println("O carro ou o cliente não existe.");
            }
        }
        else {
            System.out.println("Adicione pelo menos um cliente e um carro.");
        }
    }
    void DevolverCarro(){
        if (!listaDeVeiculos.lista.isEmpty() && !listaDeClientes.lista.isEmpty()){
            boolean carroExiste = false;
            System.out.println("Qual é a placa do carro que você quer alugar?");
            Scanner keyProcurarCarro = new Scanner(System.in);
            String placa = keyProcurarCarro.nextLine();
            Veiculo veiculo = (Veiculo) listaDeVeiculos.lista.getFirst(); // Gambiarra da forte

            for(Object V: listaDeVeiculos.lista){
                Veiculo esteCarro = (Veiculo) V;
                if (esteCarro.getPlaca().equals(placa)){
                    veiculo = esteCarro;
                    carroExiste = true;
                    break;
                }
            }

            if (carroExiste&&veiculo.estaAlugado){
                ServicoDeAluguel.DevolverVeiculo(veiculo,veiculo.clienteQueOVeiculoEstaAlugado);
            }
            else {
                System.out.println("O carro com essa placa não existe ou não está alugado.");
            }
        }
        else {
            System.out.println("Não existem carros alugados aqui");
        }
    }

    public void CriarDadosExemplo(){
        new Veiculo(TipoVeiculo.PEQUENO, "ABC-1234", listaDeVeiculos);
        new Veiculo(TipoVeiculo.MEDIO, "CBA-4321", listaDeVeiculos);
        new Veiculo(TipoVeiculo.SUV, "XYZ-1124", listaDeVeiculos);
        new Cliente("Thiago", TipoCliente.CPF, 56666332, listaDeClientes);
        new Cliente("Julia", TipoCliente.CPF, 1234567, listaDeClientes);
        new Cliente("Harambe", TipoCliente.CPF, 753129, listaDeClientes);
        new Cliente("ADA TECH", TipoCliente.CNPJ, 987654321, listaDeClientes);
        new Cliente("Mondial", TipoCliente.CNPJ, 918273645, listaDeClientes);

    }

}
