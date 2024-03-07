import Model.*;

public class Main {
    public static void main(String[] args) {
        ListaDeVeiculos lista = new ListaDeVeiculos();
        Veiculo Corsa = new Veiculo(TipoVeiculo.PEQUENO, "ABC-1234", lista);
        Veiculo Corsa2 = new Veiculo(TipoVeiculo.MEDIO, "ABC-4321", lista );
        Cliente thiago = new Cliente("Thiago",TipoCliente.CPF);

        System.out.println("Mostrando Veiculos:");
        lista.MostrarVeiculos();

        System.out.println("Alugando para o cliente Thiago");
        Corsa.alugar(thiago);

        System.out.println("Procurando Veiculos:");
        lista.ProcurarVeiculo("12");
    }
}