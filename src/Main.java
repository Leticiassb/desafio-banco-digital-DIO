import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Conta corrente = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupança(venilton);



        String menu = ("""
                \nSelecione uma opção abaixo
                1-Depositar
                2-Sacar
                3-Consultar Saldo
                4-Transferir
                """);

        Scanner selecao = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 4) {
            System.out.println(menu);
            opcao = selecao.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("""
                            \nSelecione uma opção:
                            C- Conta Corrente
                            P- Conta Poupança""");
                    String tipoConta = selecao.next();
                    if (tipoConta.equalsIgnoreCase("C")) {
                        System.out.println("Digite o valor a ser depositado: ");
                        double deposito = selecao.nextInt();

                        corrente.depositar(deposito);

                        System.out.println("Deposito Realizado");
                    }
                    if (tipoConta.equalsIgnoreCase("P")) {
                        System.out.println("Digite o valor a ser depositado: ");
                        double deposito = selecao.nextInt();

                        poupanca.depositar(deposito);

                        System.out.println("Deposito Realizado");
                    } else {
                        System.out.println("Opção inválida");
                    }
                    break;


                case 2:
                    System.out.println("""
                            \nSelecione uma opção:
                            C- Conta Corrente
                            P- Conta Poupança""");
                    String tipoConta1 = selecao.next();
                    System.out.println("Digite o valor que deseja sacar: ");
                    double saque = selecao.nextInt();
                    if (tipoConta1.equalsIgnoreCase("C")) {
                        if (saque > corrente.getSaldo()) {
                            System.out.println("Não há saldo suficiente para realizar esse saque");
                        } else {
                            corrente.sacar(saque);
                            System.out.println("Saque Realizado");

                        }
                    }
                    if (tipoConta1.equalsIgnoreCase("P"))
                        if (saque > poupanca.getSaldo()) {
                            System.out.println("Não há saldo suficiente para realizar esse saque");
                        } else {
                            poupanca.sacar(saque);
                            System.out.println("Saque Realizado");
                        }
                    break;


                case 3:
                    System.out.println("""
                            \nSelecione uma opção:
                            C- Conta Corrente
                            P- Conta Poupança""");
                    String tipoConta2 = selecao.next();
                    if (tipoConta2.equalsIgnoreCase("C")) {
                        System.out.println("Seu saldo é: R$ " + corrente.getSaldo());

                    }
                    if (tipoConta2.equalsIgnoreCase("P")) {
                        System.out.println("Seu saldo é: R$ " + poupanca.getSaldo());
                    }
                    break;

                case 4:
                    System.out.println("""
                            \nSelecione uma opção:
                            C- Conta Corrente
                            P- Conta Poupança""");
                    String tipoConta3 = selecao.next();
                    System.out.println("Digite o valor que deseja transferir: ");
                    double transferencia = selecao.nextInt();
                    if (tipoConta3.equalsIgnoreCase("C")) {
                       corrente.transferir(poupanca, transferencia );
                        System.out.println("Transferência realizada");
                    }
                    if (tipoConta3.equalsIgnoreCase("P")) {
                        poupanca.transferir(corrente, transferencia );
                        System.out.println("Transferência realizada");
                    }
                    break;



                default:
                    System.out.println("Digite uma opção válida");


            }


        }
    }
}
