package instapay_project.account;

public class WalletAccount extends Account {

    private String walletNumber;

    public WalletAccount(String walletNumber, String mobileNumber, Double balance) {
        super(mobileNumber, balance);
        this.walletNumber = walletNumber;
    }

    public String getWalletNumber() {
        return walletNumber;
    }
}
