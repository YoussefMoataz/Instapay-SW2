package instapay_project.api;

import instapay_project.account.Account;

public abstract class API {
    private String apiUrl;

    public abstract Account findAccount(String mobileNumber);
    public abstract boolean updateBalance(String mobileNumber, Double amount);
    public abstract void addAccount(Account account);

}
