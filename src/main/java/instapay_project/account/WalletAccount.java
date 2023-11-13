package instapay_project.account;

/**
 * @author Youssef Moataz
 */
public class WalletAccount extends Account {

    private String walletNumber;

    /**
     * @param walletNumber The wallet number
     * @param mobileNumber Each account has mobile number
     * @param balance Each account has balance
     */
    public WalletAccount(String walletNumber, String mobileNumber, Double balance) {
        super(mobileNumber, balance);
        this.walletNumber = walletNumber;
    }

    /**
     * @return walletNumber
     */
    public String getWalletNumber() {
        return walletNumber;
    }
}
