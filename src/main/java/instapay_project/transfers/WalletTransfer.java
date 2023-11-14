package instapay_project.transfers;

import instapay_project.account.Account;
import instapay_project.account.WalletAccount;
import instapay_project.api.WalletProviderAPI;
import instapay_project.user.User;
import instapay_project.user.UserType;

public class WalletTransfer implements Transfer{
    @Override
    public void makeTransfer(String sender, String recipient, Double amount) {
        WalletProviderAPI walletProviderAPI = WalletProviderAPI.getInstance();
        if(walletProviderAPI.findAccount(recipient) != null){
            if(walletProviderAPI.findAccount(sender).getBalance() >= amount){
                walletProviderAPI.updateBalance(sender, -1 * amount);
                walletProviderAPI.updateBalance(recipient, amount);
                System.out.println("Transaction was Successful.");
            } else {
                System.out.println("Insufficient Balance, Couldn't Complete the Action.");
            }
        } else {
            System.out.println("Invalid Mobile Number or this Number is not Associated with a Wallet Provider");
        }
    }

//    public static void main(String[] args) {
//        Account account1 = new WalletAccount("acc1", "01111", 70.0);
//        Account account2 = new WalletAccount("acc2", "02222", 70.0);
//        WalletProviderAPI.getInstance().addAccount(account1);
//        WalletProviderAPI.getInstance().addAccount(account2);
//        User user1 = new User("youssef", "01111", "xy", account1, UserType.WALLET_USER);
//        User user2 = new User("maged", "02222", "xy", account2, UserType.WALLET_USER);
//        System.out.println("Before transaction: " + user1.getBalance() + "   " + user2.getBalance());
//        WalletTransfer walletTransfer = new WalletTransfer();
//        TransferProcessor transferProcessor = new TransferProcessor();
//        transferProcessor.setTransfer(walletTransfer);
//        transferProcessor.makeTransfer("01111", "02222", 80.0);
//        System.out.println("After transaction: " + user1.getBalance() + "   " + user2.getBalance());
//    }

}
