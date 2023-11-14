package instapay_project;

import instapay_project.account.Account;
import instapay_project.account.BankAccount;
import instapay_project.api.BankAPI;
import instapay_project.user.BankRegistration;

public class Main {
    public static void main(String[] args) {

        new DummyDataMaker().createUsersWithAccounts();

        InstapayManager manager = InstapayManager.getInstance();
        manager.run();
    }
}