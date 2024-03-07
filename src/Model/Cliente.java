package Model;

import java.sql.Array;
import java.util.ArrayList;

public class Cliente {
    String nome;
    TipoCliente tipoCliente;
    ArrayList veiculosAlugados;


    public Cliente(String nome, TipoCliente tipoCliente) {
        this.nome = nome;
        this.tipoCliente = tipoCliente;
        this.veiculosAlugados = new ArrayList();
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

    public ArrayList getVeiculosAlugados() {
        return veiculosAlugados;
    }

    public void setVeiculosAlugados(ArrayList veiculosAlugados) {
        this.veiculosAlugados = veiculosAlugados;
    }
}
