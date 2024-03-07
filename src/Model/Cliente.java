package Model;
import java.util.ArrayList;
import java.util.Objects;

public class Cliente {
    String nome;
    TipoCliente tipoCliente;
    int numeroIdentificador;
    boolean numeroIdentificadorJaExiste = false;
    ArrayList veiculosAlugados = new ArrayList<>();
    ListaDeClientes listaDeClientes;

    public Cliente(String nome, TipoCliente tipoCliente, int numeroIdentificador, ListaDeClientes listaDeClientes) {

        for (Object cliente : listaDeClientes.lista) {
            Cliente ClienteAtual = (Cliente) cliente;
            if (Objects.equals(ClienteAtual.getNumeroIdentificador(), numeroIdentificador)){
                System.out.println("Um cliente com esse CPF/CNPJ já está cadastrado no sistema.");
                numeroIdentificadorJaExiste = true;
                break;
            }
        }
        if (!numeroIdentificadorJaExiste) {
            this.nome = nome;
            this.tipoCliente = tipoCliente;
            this.numeroIdentificador = numeroIdentificador;
            listaDeClientes.AddCliente(this);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public int getNumeroIdentificador() {
        return numeroIdentificador;
    }

    public void setNumeroIdentificador(int numeroIdentificador) {
        this.numeroIdentificador = numeroIdentificador;
    }

    public ArrayList getVeiculosAlugados() {
        return veiculosAlugados;
    }

    public void setVeiculosAlugados(ArrayList veiculosAlugados) {
        this.veiculosAlugados = veiculosAlugados;
    }
}
