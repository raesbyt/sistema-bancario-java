package banco.services;

import banco.model.IConta;

public class ContaService {
    
    public void depositar(IConta conta, double valor) {
        conta.depositar(valor);
    }

    public void sacar(IConta conta, double valor) {
        conta.sacar(valor);
    }

    public void transferir(IConta origim, IConta destino, double valor) {
        origim.transferir(valor, destino);
    }
    
}
