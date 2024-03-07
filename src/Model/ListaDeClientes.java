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
}
