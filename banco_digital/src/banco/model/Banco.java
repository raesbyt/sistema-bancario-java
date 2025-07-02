package banco.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    
    private String nome;
    private List<IConta> contas = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicianarConta(IConta conta) {
        contas.add(conta);
    }

    public IConta buscarContaPorNumero(String numero) {
        return contas.stream()
            .filter(c -> c.getNumero().equalsIgnoreCase(numero))
            .findFirst()
            .orElse(null);
    }

    public List<IConta> getContas() {
        return contas;
    }
    
}
