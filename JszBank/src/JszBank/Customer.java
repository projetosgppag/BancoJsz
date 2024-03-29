package JszBank;

public class Customer {
    private String cpf;
    private String name;
    private String email;
    private String phone;
    private String number;

    public Customer(String name, String cpf, String email, String phone, String number) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.number = number;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
