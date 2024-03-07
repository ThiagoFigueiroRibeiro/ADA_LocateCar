package Model;

import java.util.Objects;

public class Veiculo{
    TipoVeiculo tipoVeiculo;
    String Placa;
    boolean estaAlugado;
    boolean placaJaExiste = false;
    ListaDeVeiculos lista;

    public Veiculo(TipoVeiculo tipoVeiculo, String placa, ListaDeVeiculos lista) {
        for (Object veiculo : lista.lista) {
            Veiculo veiculoAtual = (Veiculo) veiculo;
            if (Objects.equals(veiculoAtual.getPlaca(), placa)){
                System.out.println("Um outro veículo com essa placa já existe");
                placaJaExiste = true;
                break;
            }
        }
        if (!placaJaExiste) {
            this.tipoVeiculo = tipoVeiculo;
            this.Placa = placa;
            this.lista = lista;
            lista.AddVeiculo(this);
            boolean estaAlugado = false;
        }
    }

    public TipoVeiculo getTipo() {
        return tipoVeiculo;
    }

    public boolean isAlugado() {
        return estaAlugado;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public void alugar(Cliente cliente){
        if (estaAlugado){
            System.out.println("Esse veículo já está alugado.");
        }
        else {
            cliente.veiculosAlugados.add(this);
            estaAlugado = true;
        }
    }
    public void devolver(Cliente cliente){
        if (!estaAlugado){
            System.out.println("Esse veículo não está alugado.");
        }
        else {
            cliente.veiculosAlugados.remove(this);
            estaAlugado = false;
        }
    }
}
