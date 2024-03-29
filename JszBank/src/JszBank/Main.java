package JszBank;

import java.util.Scanner;

public class Main {
    private static Customer customer;
    private static CurrentAccount contaCorrente;
    private static SavingsAccount contaPoupas;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean logou = login();
        if(logou) menu();
        else System.out.println("login invalido");
        sc.close();
    }

    public static boolean login(){
        System.out.print("user: ");
        String user = sc.nextLine();
        System.out.print("password: ");
        String pass = sc.nextLine();
        if(user.equals("admin") && pass.equals("admin")) return true;
        else return false;
    }

    public static void menu(){
        int op;
        do{
            System.out.print("##--BancoJsz--##\n\n");
            System.out.print("|------------------------------|\n");
            System.out.print("| Opção 1 - Abrir conta        |\n");
            System.out.print("| Opção 2 - Deletar conta      |\n");
            System.out.print("| Opção 3 - Depositar          |\n");
            System.out.print("| Opção 4 - Saque              |\n");
            System.out.print("| Opção 5 - Ver dados da conta |\n");
            System.out.print("| Opção 6 - Sair               |\n");
            System.out.print("|------------------------------|\n");
            System.out.print("Digite uma opção: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op){
                case 1:
                    System.out.println("Digite o nome do cliente:");
                    String name = sc.nextLine();
                    System.out.println("Digite o CPF do cliente:");
                    String cpf = sc.nextLine();
                    System.out.println("Digite o email do cliente:");
                    String email = sc.nextLine();
                    System.out.println("Digite o telefone do cliente:");
                    String phone = sc.nextLine();
                    System.out.println("Digite o id do cliente:");
                    String number = sc.nextLine();
                    customer = new Customer(name,cpf,email,phone,number);

                    System.out.println("digite 1 para abrir uma conta corrente, 2 para poupança");
                    int op2 = sc.nextInt();
                    sc.nextLine();
                    if(op2 == 1){
                        contaCorrente = new CurrentAccount(customer);
                    } else if(op2 == 2){contaPoupas = new SavingsAccount(customer);}
                    break;
                case 2:
                    if (contaCorrente != null || contaPoupas != null) {
                        contaCorrente = null;
                        contaPoupas = null;
                        customer = null;
                        System.out.println("deletado");
                    } else {
                        System.out.println("não tem conta para deletar");
                    }
                    break;
                case 3:
                    if (contaCorrente != null) {
                        System.out.println("Digite o valor do depósito:");
                        double amount = sc.nextDouble();
                        sc.nextLine();
                        contaCorrente.deposit(amount);
                    } else {
                        System.out.println("crie uma conta");
                    }
                    break;
                case 4:
                    if (contaCorrente != null) {
                        System.out.println("Digite o valor do saque:");
                        double amount = sc.nextDouble();
                        sc.nextLine();
                        contaCorrente.withdraw(amount);
                    } else {
                        System.out.println("crie uma conta");
                    }
                    break;
                case 5:
                    if (contaCorrente != null) contaCorrente.showAccount();
                    else if(contaPoupas != null) contaPoupas.showAccount();
                    else System.out.println("n tem conta");
                    break;
                case 6:
                    System.out.println("adeus");
                    System.exit(0);
                    break;
                default:
                    System.out.println("[ERRO]");
                    System.exit(0);
                    break;
            }
        } while(op != 6);
    }

}
