package Model;
import java.io.FileWriter;
import java.io.IOException;
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
            System.out.println("Lista de clientes atualmente vazia.");
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

    void SalvarDados(){
        try{
            FileWriter fileWriter = new FileWriter("ListaDeClientes.txt");
            if (lista.isEmpty()){
                fileWriter.write("Lista de clientes atualmente vazia.");
            }
            else {
                for (Cliente cliente : lista) {
                    fileWriter.write(
                    cliente.getNome() + ", " +
                        cliente.getNumeroIdentificador() + "\n");
                }
            }
            fileWriter.close();
        } catch (IOException ioException) {
            System.out.println("Algo deu errado na gravação da lista de clientes...");
            ioException.printStackTrace();
        }
    }

}
