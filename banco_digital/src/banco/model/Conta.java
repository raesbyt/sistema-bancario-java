package banco.model;

public abstract class Conta implements IConta {
    
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected String agencia;
    protected String numero;
    protected double saldo;
    protected double limiteSaque;

    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = "000" + AGENCIA_PADRAO;
        this.numero = "000-" + SEQUENCIAL++;
        this.cliente = cliente;
        saldo = 0d;
    }

    @Override
    public String getNumero() {
        return numero;
    }

    @Override
    public String getTitular() {
        return cliente.getNome();
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public abstract void imprimirExtrato();

}
