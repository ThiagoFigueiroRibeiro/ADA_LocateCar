package Model;
import java.util.ArrayList;
public class ListaDeClientes {
    ArrayList<Cliente> lista;
    public ListaDeClientes() {
        this.lista = new ArrayList<>();
    }
     void AddCliente(Cliente cliente){
        lista.add(cliente);
    }

     ArrayList<Cliente> getLista() {
        return lista;
    }

     void MostrarClientes(){
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
