package Model;
import java.time.LocalDateTime;
import java.util.Objects;
import java.time.Duration;


public class Veiculo{
    TipoVeiculo tipoVeiculo;
    String Placa;
    boolean estaAlugado;
    boolean placaJaExiste = false;
    ListaDeVeiculos lista;
    LocalDateTime dataDoAluguel;
    LocalDateTime dataDaDevolucao;
    Cliente clienteQueOVeiculoEstaAlugado;

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
            this.estaAlugado = false;
            this.clienteQueOVeiculoEstaAlugado = null;
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

    public void alugar(Cliente cliente, LocalDateTime dataDoAluguel){
        if (estaAlugado){
            System.out.println("Esse veículo já está alugado.");
        }
        else {
            cliente.veiculosAlugados.add(this);
            this.dataDoAluguel = dataDoAluguel;
            this.estaAlugado = true;
            this.clienteQueOVeiculoEstaAlugado = cliente;
        }
    }
    public void devolver(Cliente cliente, LocalDateTime dataDaDevolucao){
        if (!estaAlugado){
            System.out.println("Esse veículo não está alugado.");
        }
        else {
            cliente.veiculosAlugados.remove(this);
            this.dataDaDevolucao = dataDaDevolucao;
            Duration diff = Duration.between(dataDoAluguel,dataDaDevolucao);
            System.out.println("Esse veiculo ficou alugado por " + diff.toDays() + " dias" );
            this.estaAlugado = false;
            this.clienteQueOVeiculoEstaAlugado = null;
        }
    }

    public long DiasAlugados() {
        Duration diff = Duration.between(dataDoAluguel,dataDaDevolucao);
        return diff.toDays();
    }
    public Veiculo RetornoDeVeiculo(){
        return this;
    }
}
