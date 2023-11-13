package instapay_project;

import instapay_project.account.Account;
import instapay_project.account.BankAccount;
import instapay_project.api.BankAPI;
import instapay_project.user.BankRegistration;

public class Main {
    public static void main(String[] args) {
        Account a =new BankAccount("011","01111111111",520D);
        BankAPI.getInstance().addAccount(a);
        BankRegistration b=new BankRegistration();
        b.register();
    }
}