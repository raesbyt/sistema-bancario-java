package application;

import java.util.Locale;
import java.util.Scanner;

import banco.model.Banco;
import banco.model.Cliente;
import banco.model.ContaCorrente;
import banco.model.ContaPoupanca;
import banco.model.IConta;
import banco.services.ContaService;

public class App {

    private static ContaService sevice;
    private static Scanner input;
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        input = new Scanner(System.in);

        Banco banco = new Banco("Banco Digital");
        sevice = new ContaService();
        String numeroPoupanca = "";

        while (true) {
            System.out.println("\n=== " + banco.getNome() + " ===");
            System.out.println("1. Criar Conta Corrente");
            System.out.println("2. Acessar Conta");
            System.out.println("0. Sair");
            System.out.print("Opeção: ");
            int opcao = input.nextInt();

            if (opcao == 1) {
                input.nextLine();
                System.out.print("Nome do cliente: ");
                var nome = input.nextLine();

                ContaCorrente conta = new ContaCorrente(new Cliente(nome));
                ContaPoupanca contaPoupanca = new ContaPoupanca(new Cliente(nome));
                banco.adicianarConta(conta);
                banco.adicianarConta(contaPoupanca);
                numeroPoupanca = contaPoupanca.getNumero();
                System.out.println("Conta criada com sucesso! Número: "
                        + conta.getNumero());

            } else if (opcao == 2) {
                input.nextLine();
                System.out.print("Número da conta: ");
                String numero = input.nextLine();

                IConta conta = banco.buscarContaPorNumero(numero);
                IConta conta2 = banco.buscarContaPorNumero(numeroPoupanca);
                if (conta == null) {
                    System.out.println("Conta não encontrada.");
                    continue;
                }

                int acao;
                do {
                    System.out.println("\nConta Corrente:");
                    System.out.println("Ben-vindo, " + conta.getTitular());
                    System.out.println("1. Depositar");
                    System.out.println("2. Sacar");
                    System.out.println("3. Transferir");
                    System.out.println("4. Extrato");
                    System.out.println("5. Poupança");
                    System.out.println("0. Sair");
                    System.out.print("Opcão: ");
                    acao = input.nextInt();

                    switch (acao) {
                        case 1 -> {
                            System.out.print("Valor: R$ ");
                            sevice.depositar(conta, input.nextDouble());
                        }
                        case 2 -> {
                            System.out.print("Valor: R$ ");
                            sevice.sacar(conta, input.nextDouble());
                        }
                        case 3 -> {
                            input.nextLine();
                            System.out.print("Conta destino: ");
                            IConta destino = banco.buscarContaPorNumero(input.nextLine());
                            if (destino != null) {
                                System.out.print("Valor: R$ ");
                                sevice.transferir(conta, destino, input.nextDouble());

                            } else {
                                System.out.println("Conta não encontrada.");
                            }

                        }
                        case 4 -> ((ContaCorrente) conta).imprimirExtrato();
                        case 5 -> poupanca(conta, conta2);
                        case 0 -> System.out.println("Saindo da conta.");

                        default -> System.out.println("Opção inválida.");

                    }

                } while (acao != 0);

            } else if (opcao == 0) {
                System.out.println("Encerrando...");
                break;

            } else {
                System.out.println("Opção inválida.");

            }

        }
        input.close();

    }

    private static void poupanca(IConta corrente, IConta poupanca) {
        int opcao;
        do {
            System.out.println("\nConta Poupança:");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar para c\\c");
            System.out.println("3. Extrato");
            System.out.println("0. Sair");
            System.out.print("Opcão: ");
            opcao = input.nextInt();

            if (opcao == 1) {
                if (corrente != null) {
                    System.out.print("Valor: R$ ");
                    sevice.transferir(corrente, poupanca, input.nextDouble());

                } else {
                    System.out.println("Conta não encontrada.");
                }

            } else if (opcao == 2) {
                if (corrente != null) {
                    System.out.print("Valor: R$ ");
                    sevice.transferir(poupanca, corrente, input.nextDouble());

                } else {
                    System.out.println("Conta não encontrada.");
                }

            } else if (opcao == 3) {
                System.out.println("\nImprimindo Extrato:");
                ((ContaPoupanca) poupanca).imprimirExtrato();

            } else if (opcao == 0) {
                System.out.println("Encerrando...");
                break;

            } else {
                System.out.println("Opção inválida.");
            }
            
        } while (true);
        
    }

}
