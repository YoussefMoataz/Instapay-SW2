package instapay_project.transfers;

import instapay_project.InstapayManager;
import instapay_project.account.Account;
import instapay_project.account.BankAccount;
import instapay_project.account.WalletAccount;
import instapay_project.api.BankAPI;
import instapay_project.api.InstapayAPI;
import instapay_project.api.WalletProviderAPI;
import instapay_project.user.User;
import instapay_project.user.UserType;

public class InstapayTransfer implements Transfer{
    @Override
    public void makeTransfer(String sender, String recipient, Double amount) {
        User user1 = InstapayManager.getInstance().getCurrentUser();
        User user2 = InstapayAPI.getInstance().getUser(recipient);
        if(user2 != null){
            if(user1.getUserType() == user2.getUserType() && user1.getUserType() == UserType.BANK_USER){
                if(BankAPI.getInstance().findAccount(user1.getMobileNumber()).getBalance() >= amount){
                    BankAPI.getInstance().updateBalance(user1.getMobileNumber(), -1 * amount);
                    BankAPI.getInstance().updateBalance(user2.getMobileNumber(), amount);
                } else {
                    System.out.println("Insufficient Balance.");
                }
            } else if(user1.getUserType() == user2.getUserType() && user1.getUserType() == UserType.WALLET_USER){
                if(WalletProviderAPI.getInstance().findAccount(user1.getMobileNumber()).getBalance() >= amount){
                    WalletProviderAPI.getInstance().updateBalance(user1.getMobileNumber(), -1 * amount);
                    WalletProviderAPI.getInstance().updateBalance(user2.getMobileNumber(), amount);
                } else {
                    System.out.println("Insufficient Balance.");
                }
            } else if(user1.getUserType() != user2.getUserType() && user1.getUserType() == UserType.BANK_USER) {
                if(BankAPI.getInstance().findAccount(user1.getMobileNumber()).getBalance() >= amount){
                    BankAPI.getInstance().updateBalance(user1.getMobileNumber(), -1 * amount);
                    WalletProviderAPI.getInstance().updateBalance(user2.getMobileNumber(), amount);
                } else {
                    System.out.println("Insufficient Balance.");
                }
            } else {
                System.out.println("Couldn't Complete Transaction, Can't Transfer from a Wallet to a Bank Account.");
            }
        } else {
            System.out.println("Invalid Username.");
        }
    }

//    public static void main(String[] args) {
//        Account account1 = new BankAccount("1111", "01111", 150.0);
//        Account account2 = new BankAccount("2222", "02222", 90.0);
//        Account account3 = new WalletAccount("3333", "03333", 200.0);
//        Account account4 = new WalletAccount("4444", "04444", 50.0);
//        BankAPI.getInstance().addAccount(account1);
//        BankAPI.getInstance().addAccount(account2);
//        WalletProviderAPI.getInstance().addAccount(account3);
//        WalletProviderAPI.getInstance().addAccount(account4);
//        User user1 = new User("maged", "01111", "xy", account1, UserType.BANK_USER);
//        User user2 = new User("youssef", "02222", "xy", account2, UserType.BANK_USER);
//        User user3 = new User("hassan", "03333", "xy", account3, UserType.WALLET_USER);
//        User user4 = new User("xyz", "04444", "xy", account4, UserType.WALLET_USER);
//        InstapayManager.addUser(user1);
//        InstapayManager.addUser(user2);
//        InstapayManager.addUser(user3);
//        InstapayManager.addUser(user4);
//        System.out.println("Before Transaction: " + user1.getBalance() + "    " + user4.getBalance());
//        TransferProcessor transferProcessor = new TransferProcessor();
//        transferProcessor.setTransfer(new InstapayTransfer());
//        transferProcessor.makeTransfer(user1.getUserName(), user4.getUserName(), 90.0);
//        System.out.println("After Transaction: " + user1.getBalance() + "    " + user4.getBalance());
//    }
}
