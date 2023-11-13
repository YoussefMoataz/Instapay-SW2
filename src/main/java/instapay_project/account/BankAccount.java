package instapay_project.account;

/**
 * @author Youssef Moataz
 */
public class BankAccount extends Account {

    private String accountNumber;

    /**
     * @param accountNumber The bank account number
     * @param mobileNumber Each account has mobile number
     * @param balance Each account has balance
     */
    public BankAccount(String accountNumber, String mobileNumber, Double balance) {
        super(mobileNumber, balance);
        this.accountNumber = accountNumber;
    }

    /**
     * @return accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }
}
