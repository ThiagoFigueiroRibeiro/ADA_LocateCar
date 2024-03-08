package Model;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Scanner;

 public class ServicoDeAluguel {
     void AlugarVeiculo(Veiculo veiculo, Cliente cliente){
        LocalDateTime dataDoAluguel = PerguntarData();
        veiculo.alugar(cliente,dataDoAluguel);
    }

     void DevolverVeiculo(Veiculo veiculo, Cliente cliente){
        LocalDateTime dataDaDevolucao = PerguntarData();
        veiculo.devolver(cliente, dataDaDevolucao);
        ExibirCustoTotalDeAluguel(cliente,veiculo);
    }

     void ExibirCustoTotalDeAluguel(Cliente cliente, Veiculo veiculo){
        BigDecimal total = calcularCustoTotal(cliente,veiculo,veiculo.DiasAlugados());
        System.out.println("O custo total de aluguel é de R$ " + total);
    }

     BigDecimal calcularCustoTotal(Cliente cliente, Veiculo veiculo, long DiasAlugados){
        BigDecimal custoTotal = BigDecimal.valueOf(0.0);
        //CPF
        if (cliente.getTipoCliente()==TipoCliente.CPF && DiasAlugados > 5){
            custoTotal = BigDecimal.valueOf(valoresDiariasPorTipo(veiculo)*DiasAlugados*0.95);}
        else if (cliente.getTipoCliente()==TipoCliente.CPF && DiasAlugados <= 5) {
            custoTotal = BigDecimal.valueOf(valoresDiariasPorTipo(veiculo)*DiasAlugados);}
        //CNPJ
        else if (cliente.getTipoCliente()==TipoCliente.CNPJ && DiasAlugados > 3){
            custoTotal = BigDecimal.valueOf(valoresDiariasPorTipo(veiculo)*DiasAlugados*0.90);}
        else if (cliente.getTipoCliente()==TipoCliente.CNPJ && DiasAlugados <= 3) {
            custoTotal = BigDecimal.valueOf(valoresDiariasPorTipo(veiculo)*DiasAlugados);
        }
        return custoTotal;
    }

     int valoresDiariasPorTipo(Veiculo veiculo){
        int valor = 0;
        if(veiculo.getTipo()==TipoVeiculo.PEQUENO){valor = 100;}
        else if(veiculo.getTipo()==TipoVeiculo.MEDIO){valor = 150;}
        else if(veiculo.getTipo()==TipoVeiculo.SUV){valor = 200;}
        return valor;
    }

     LocalDateTime PerguntarData(){
        System.out.println("Qual é o mes que você quer alugar o carro? (1 a 12)");
        Scanner keyboard = new Scanner(System.in);
        int myint = keyboard.nextInt();
        System.out.println("Qual é o DIA que você quer alugar o carro? (1 a 31)");
        int dia = keyboard.nextInt();
        System.out.println("Qual é a HORA que você quer alugar o carro? (0 a 24)");
        int hora = keyboard.nextInt();
        System.out.println("Qual é o MINUTO que você quer alugar o carro? (0 a 60)");
        int minuto = keyboard.nextInt();
        return LocalDateTime.of(2024, Month.of(myint), dia, hora, minuto);
    }
}
