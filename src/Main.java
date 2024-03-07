import Model.*;
public class Main {
    public static void main(String[] args) {
        ListaDeVeiculos listaDeVeiculos = new ListaDeVeiculos();
        ListaDeClientes listaDeClientes = new ListaDeClientes();
        Model.Menu menu = new Model.Menu(listaDeVeiculos,listaDeClientes);
        menu.CriarDadosExemplo();
        menu.ExibirMenu();
    }
}