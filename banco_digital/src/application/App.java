package application;

import banco.model.IConta;
import banco.services.ContaService;
import banco.model.Cliente;
import banco.model.ContaCorrente;
import banco.model.ContaPoupanca;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Banco Digital ===");

        Cliente cliente1 = new Cliente("João");
        Cliente cliente2 = new Cliente("Ana");

        IConta contaCorrente = new ContaCorrente(cliente1);
        IConta contaPoupanca = new ContaPoupanca(cliente2);

        ContaService service = new ContaService();

        service.depositar(contaCorrente, 220d);
        service.transferir(contaCorrente, contaPoupanca, 50d);

        System.out.println("Imprimindo Extrato:");
        ((ContaCorrente) contaCorrente).imprimirExtrato();
        ((ContaPoupanca) contaPoupanca).imprimirExtrato();
    }
}
