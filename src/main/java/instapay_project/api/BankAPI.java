package instapay_project.api;

import instapay_project.account.Account;
import instapay_project.account.BankAccount;
import instapay_project.account.WalletAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Youssef Moataz
 */
public class BankAPI extends API {

    private static BankAPI instance = null;
    private static Map<String, BankAccount> accounts;

    private BankAPI() {
    }

    /**
     * To apply Singleton pattern, this method returns single instance of this class.
     * @return BankAPI instance
     */
    public static BankAPI getInstance() {
        if (instance == null) {
            instance = new BankAPI();
            accounts = new HashMap<>();
        }
        return instance;
    }

    @Override
    public Account findAccount(String mobileNumber) {

        for (Map.Entry<String, BankAccount> a : accounts.entrySet()) {
            if (Objects.equals(a.getKey(), mobileNumber)) {
                return a.getValue();
            }
        }

        return null;
    }

    @Override
    public Account findAccountByAccountNumber(String accountNumber) {
        for (Map.Entry<String, BankAccount> a : accounts.entrySet()) {
            if (Objects.equals(a.getValue().getAccountNumber(), accountNumber)) {
                return a.getValue();
            }
        }
        return null;
    }

    @Override
    public boolean updateBalance(String mobileNumber, Double amount) {

        if (accounts.containsKey(mobileNumber)) {
            BankAccount account = accounts.get(mobileNumber);
            account.setBalance(account.getBalance() + amount);
            accounts.put(mobileNumber, account);
            return true;
        }
        return false;
    }

    @Override
    public void addAccount(Account account) {
        accounts.put(account.getMobileNumber(), (BankAccount) account);
    }

    @Override
    public boolean isAccountExists(String accountNumber) {
        for (Map.Entry<String, BankAccount> a : accounts.entrySet()) {
            if (Objects.equals(a.getValue().getAccountNumber(), accountNumber)) {
                return true;
            }
        }
        return false;
    }
}
