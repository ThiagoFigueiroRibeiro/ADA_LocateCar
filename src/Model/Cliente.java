package Model;
import java.util.ArrayList;
import java.util.Objects;

 class Cliente {
    String nome;
    TipoCliente tipoCliente;
    int numeroIdentificador;
    boolean numeroIdentificadorJaExiste = false;
    ArrayList<Veiculo> veiculosAlugados = new ArrayList<>();
    ListaDeClientes listaDeClientes;

     Cliente(String nome, TipoCliente tipoCliente, int numeroIdentificador, ListaDeClientes listaDeClientes) {

        for (Cliente cliente : listaDeClientes.lista) {
            if (Objects.equals(cliente.getNumeroIdentificador(), numeroIdentificador)){
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

     String getNome() {
        return nome;
    }

     void setNome(String nome) {
        this.nome = nome;
    }

     TipoCliente getTipoCliente() {
        return tipoCliente;
    }

     void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

     int getNumeroIdentificador() {
        return numeroIdentificador;
    }

     void setNumeroIdentificador(int numeroIdentificador) {
        this.numeroIdentificador = numeroIdentificador;
    }

     ArrayList<Veiculo> getVeiculosAlugados() {
        return veiculosAlugados;
    }

     void setVeiculosAlugados(ArrayList<Veiculo> veiculosAlugados) {
        this.veiculosAlugados = veiculosAlugados;
    }
}
