package banco.model;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.printf("Titular: %s%n | Agência: %s%n | ContaCorente: %s%n "
                        + "| Saldo: %.2f%n",
                        getTitular(), agencia, numero, saldo);
    }
    
}
