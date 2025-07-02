package banco.model;

public interface IConta {

    String getNumero();
    String getTitular();
    void sacar(double valor);
    void depositar(double valor);
    void transferir(double valor, IConta contaDestino);

}
