package JszBank;

public abstract class Account implements IAccount {
    protected double balance;
    protected Customer customer;


    public Account(Customer customer){
        this.balance = 0.0;
        this.customer = customer;
    }
    @Override
    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("agora seu saldo é:" + this.balance);
    }

    @Override
    public void withdraw(double amount) {
        if(this.balance>= amount){
            this.balance -= amount;
            System.out.println("saldo atual: " + this.balance);
        } else{
            System.out.println("saldo insuficiente");
        }
    }

    @Override
    public void showBalance() {
        System.out.println("saldo atual: " + this.balance);
    }

    @Override
    public void showAccount() {
        System.out.println("Nome: " + this.customer.getName() + "\nID da conta: " + this.customer.getNumber() +"\nCPF: " + this.customer.getCpf() + "\nSaldo: " + this.balance + "\nEmail: " + this.customer.getEmail() + "\nTel: " + this.customer.getPhone());
    }
}
