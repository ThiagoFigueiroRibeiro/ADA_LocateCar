import Model.*;
public class Main {
    public static void main(String[] args) {
        ListaDeVeiculos listaDeVeiculos = new ListaDeVeiculos();
        ListaDeClientes listaDeClientes = new ListaDeClientes();
        ServicoDeAluguel servicoDeAluguel = new ServicoDeAluguel();
        Model.Menu menu = new Model.Menu(listaDeVeiculos,listaDeClientes,servicoDeAluguel);
        menu.CriarDadosExemplo();
        menu.ExibirMenu();
    }
}