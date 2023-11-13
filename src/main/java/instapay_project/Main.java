package instapay_project;

import instapay_project.User.BankRegistration;
import instapay_project.User.Registration;
import instapay_project.account.Account;
import instapay_project.account.BankAccount;
import instapay_project.api.API;
import instapay_project.api.APIFacade;
import instapay_project.api.BankAPI;

public class Main {
    public static void main(String[] args) {
        BankAccount b=new BankAccount("011","01011111111",100.45);
        BankAPI.getInstance().addAccount(b);
        BankRegistration r=new BankRegistration();
        r.register();
    }
}