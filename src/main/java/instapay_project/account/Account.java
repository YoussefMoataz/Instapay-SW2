package instapay_project.account;

/**
 * @author Youssef Moataz
 */
public abstract class Account {
    private String mobileNumber;
    private Double balance;

    /**
     * @param mobileNumber Each account has mobile number
     * @param balance Each account has balance
     */
    public Account(String mobileNumber, Double balance) {
        this.mobileNumber = mobileNumber;
        this.balance = balance;
    }

    /**
     * @return mobileNumber
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * @return balance
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * @param balance The new balance.
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
