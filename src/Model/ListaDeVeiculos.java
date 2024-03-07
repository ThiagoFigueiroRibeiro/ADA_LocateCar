package Model;
import java.util.ArrayList;

public class ListaDeVeiculos {
    ArrayList lista;

    public ListaDeVeiculos() {
        this.lista = new ArrayList();
    }
    public void AddVeiculo(Veiculo veiculo){
        lista.add(veiculo);
    }
    public void MostrarVeiculos(){
        if (lista.isEmpty()){
            System.out.println("Lista atualmente vazia.");
        }
        else {
            for (Object veiculo : lista) {
                Veiculo veiculoAtual = (Veiculo) veiculo;
                ShowStatus(veiculoAtual);
            }
        }
    }
    public void ProcurarVeiculo(String placa){
        boolean achouCarro = false;
        if (lista.isEmpty()){
            System.out.println("Lista atualmente vazia.");
        }
        else {
            for (Object veiculo : lista) {
                Veiculo veiculoAtual = (Veiculo) veiculo;
                if(veiculoAtual.getPlaca().contains(placa)) {
                    ShowStatus(veiculoAtual);
                    achouCarro = true;
                }
            }
        }
        if (!achouCarro){
            System.out.println("Não achamos carro com essa placa.");
        }
    }
    void ShowStatus(Veiculo veiculoAtual){
        System.out.print(veiculoAtual.getPlaca());
        System.out.print(", " + veiculoAtual.getTipo());
        if (veiculoAtual.estaAlugado){
            System.out.println(", Está alugado desde " + veiculoAtual.dataDoAluguel);
        }
        else{
            System.out.println(", Está disponível");
        }
    }
}


