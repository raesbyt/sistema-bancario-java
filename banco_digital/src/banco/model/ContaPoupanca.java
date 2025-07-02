package banco.model;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.printf("Titular: %s%n | Agência: %s%n | ContaPoupanca: %s%n "
                        + "| Saldo: %.2f%n",
                        getTitular(), agencia, numero, saldo);
    }
    
}
