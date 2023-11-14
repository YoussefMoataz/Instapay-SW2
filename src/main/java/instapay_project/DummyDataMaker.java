package instapay_project;

import instapay_project.account.Account;
import instapay_project.account.BankAccount;
import instapay_project.account.WalletAccount;
import instapay_project.api.BankAPI;
import instapay_project.api.InstapayAPI;
import instapay_project.api.WalletProviderAPI;
import instapay_project.user.User;
import instapay_project.user.UserType;

public class DummyDataMaker {

    public void createUsersWithAccounts() {
        Account account1 = new BankAccount("1111", "01033148446", 150.0);
        Account account2 = new BankAccount("2222", "01028746860", 90.0);
        Account account3 = new WalletAccount("3333", "01011993990", 200.0);
        Account account4 = new WalletAccount("4444", "04444", 50.0);
        BankAPI.getInstance().addAccount(account1);
        BankAPI.getInstance().addAccount(account2);
        WalletProviderAPI.getInstance().addAccount(account3);
        WalletProviderAPI.getInstance().addAccount(account4);
        User user1 = new User("Youssef", "01033148446", "Pass@123", account1, UserType.BANK_USER);
        User user2 = new User("Maged", "01028746860", "xy", account2, UserType.BANK_USER);
        User user3 = new User("Hassan", "01011993990", "xy", account3, UserType.WALLET_USER);
        User user4 = new User("Ahmed", "01011111111", "xy", account4, UserType.WALLET_USER);
        InstapayAPI.getInstance().addUser(user1);
        InstapayAPI.getInstance().addUser(user2);
        InstapayAPI.getInstance().addUser(user3);
        InstapayAPI.getInstance().addUser(user4);
    }

}
