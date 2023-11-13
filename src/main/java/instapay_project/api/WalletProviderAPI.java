package instapay_project.api;

import instapay_project.account.Account;
import instapay_project.account.BankAccount;
import instapay_project.account.WalletAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WalletProviderAPI extends API{

    private static WalletProviderAPI instance = null;
    private static Map<String, WalletAccount> accounts;

    private WalletProviderAPI() {
    }

    public static WalletProviderAPI getInstance() {
        if (instance == null) {
            instance = new WalletProviderAPI();
            accounts = new HashMap<>();
        }
        return instance;
    }

    @Override
    public Account findAccount(String mobileNumber) {

        for (Map.Entry<String, WalletAccount> a : accounts.entrySet()) {
            if (Objects.equals(a.getKey(), mobileNumber)) {
                return a.getValue();
            }
        }

        return null;
    }

    @Override
    public boolean updateBalance(String mobileNumber, Double amount) {

        if (accounts.containsKey(mobileNumber)) {
            WalletAccount account = accounts.get(mobileNumber);
            account.setBalance(account.getBalance() + amount);
            accounts.put(mobileNumber, account);
            return true;
        }
        return false;
    }

    @Override
    public void addAccount(Account account) {
        accounts.put(account.getMobileNumber(), (WalletAccount) account);
    }
}
