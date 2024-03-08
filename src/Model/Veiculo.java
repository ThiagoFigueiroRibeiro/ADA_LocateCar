package Model;
import java.time.LocalDateTime;
import java.util.Objects;
import java.time.Duration;


 class Veiculo{
    TipoVeiculo tipoVeiculo;
    String Placa;
    boolean estaAlugado;
    boolean placaJaExiste = false;
    ListaDeVeiculos lista;
    LocalDateTime dataDoAluguel;
    LocalDateTime dataDaDevolucao;
    Cliente clienteQueOVeiculoEstaAlugado;

     Veiculo(TipoVeiculo tipoVeiculo, String placa, ListaDeVeiculos lista) {
        for (Veiculo veiculo : lista.lista) {
            if (Objects.equals(veiculo.getPlaca(), placa)){
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

     TipoVeiculo getTipo() {
        return tipoVeiculo;
    }

     boolean isAlugado() {
        return estaAlugado;
    }

     String getPlaca() {
        return Placa;
    }

     void setPlaca(String placa) {
        Placa = placa;
    }

     void alugar(Cliente cliente, LocalDateTime dataDoAluguel){
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
     void devolver(Cliente cliente, LocalDateTime dataDaDevolucao){
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

     long DiasAlugados() {
        Duration diff = Duration.between(dataDoAluguel,dataDaDevolucao);
        return diff.toDays();
    }
     Veiculo RetornoDeVeiculo(){
        return this;
    }
}
