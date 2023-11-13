package instapay_project.account;

public class BankAccount extends Account {

    private String accountNumber;

    public BankAccount(String accountNumber, String mobileNumber, Double balance) {
        super(mobileNumber, balance);
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
