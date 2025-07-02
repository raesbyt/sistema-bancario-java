package application;

import banco.model.IConta;
import banco.services.ContaService;
import banco.model.Banco;
import banco.model.Cliente;
import banco.model.ContaCorrente;
import banco.model.ContaPoupanca;

public class App {
    public static void main(String[] args) throws Exception {

        Banco banco = new Banco("Banco Digital");
        System.out.println("=== " + banco.getNome() + " ===");

        ContaCorrente contaCorrente = new ContaCorrente(new Cliente("João"));
        ContaPoupanca contaPoupanca = new ContaPoupanca(new Cliente("Ana"));

        banco.adicianarConta(contaCorrente);
        banco.adicianarConta(contaPoupanca);

        IConta cc = banco.buscarContaPorNumero(contaCorrente.getNumero());
        IConta cp = banco.buscarContaPorNumero(contaPoupanca.getNumero());

        ContaService service = new ContaService();

        service.depositar(cc, 220d);
        service.transferir(cc, cp, 50d);

        System.out.println("Imprimindo Extrato:");
        ((ContaCorrente) cc).imprimirExtrato();
        ((ContaPoupanca) cp).imprimirExtrato();
    }
}
