package instapay_project.account;

public abstract class Account {
    private String mobileNumber;
    private Double balance;

    public Account(String mobileNumber, Double balance) {
        this.mobileNumber = mobileNumber;
        this.balance = balance;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
