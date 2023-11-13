package instapay_project.api;

import instapay_project.account.Account;
import instapay_project.account.BankAccount;

import java.util.HashMap;
import java.util.Map;

public class BankAPI extends API {

    private static BankAPI instance = null;
    private static Map<String, BankAccount> accounts;

    private BankAPI() {
    }

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
            if (a.getKey() == mobileNumber) {
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
}
