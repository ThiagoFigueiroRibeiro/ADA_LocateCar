package Model;
import java.util.ArrayList;
public class ListaDeClientes {
    ArrayList lista;
    public ListaDeClientes() {
        this.lista = new ArrayList();
    }
    public void AddCliente(Cliente cliente){
        lista.add(cliente);
    }

    public ArrayList getLista() {
        return lista;
    }

    public void MostrarClientes(){
        if (lista.isEmpty()){
            System.out.println("Lista atualmente vazia.");
        }
        else {
            for (Object cliente : lista) {
                Cliente clienteAtual = (Cliente) cliente;
                ShowStatus(clienteAtual);
            }
        }
    }
    void ShowStatus(Cliente clienteAtual){
        System.out.print(clienteAtual.getNome());
        System.out.print(", " + clienteAtual.getTipoCliente());
        System.out.println(", " + clienteAtual.getNumeroIdentificador());
    }
}
