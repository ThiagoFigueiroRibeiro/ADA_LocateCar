package Model;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ListaDeVeiculos {
    ArrayList<Veiculo> lista;

    public ListaDeVeiculos() {
        this.lista = new ArrayList<>();
    }
     void AddVeiculo(Veiculo veiculo){
        lista.add(veiculo);
    }
     void MostrarVeiculos(){
        if (lista.isEmpty()){
            System.out.println("Lista de veículos atualmente vazia.");
        }
        else {
            for (Object veiculo : lista) {
                Veiculo veiculoAtual = (Veiculo) veiculo;
                ShowStatus(veiculoAtual);
            }
        }
    }
     void ProcurarVeiculo(String placa){
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

    void SalvarDados(){
        try{
            FileWriter fileWriter = new FileWriter("ListaDeCarros.txt");
            if (lista.isEmpty()){
                fileWriter.write("Lista de veículos atualmente vazia.");
            }
            else {
                for (Veiculo veiculo : lista) {
                    if (veiculo.estaAlugado){
                        fileWriter.write(veiculo.getPlaca() + ", "
                                + veiculo.getTipo() + ", "
                                + "Está alugado desde " + veiculo.dataDoAluguel +"\n");
                    }
                    else{
                        fileWriter.write(veiculo.getPlaca() + ", "
                                + veiculo.getTipo() + ", "
                                + "Está disponível.\n");
                    }
                }
            }
            fileWriter.close();
        } catch (IOException ioException) {
            System.out.println("Algo deu errado na gravação da lista de veículos...");
            ioException.printStackTrace();
        }
    }
}


