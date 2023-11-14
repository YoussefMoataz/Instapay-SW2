package instapay_project.transfers;

import instapay_project.account.Account;
import instapay_project.account.BankAccount;
import instapay_project.api.BankAPI;
import instapay_project.user.User;
import instapay_project.user.UserType;

public class BankTransfer implements Transfer{
    @Override
    public void makeTransfer(String sender, String recipient, Double amount) {
        BankAPI bankAPI = BankAPI.getInstance();
        if(bankAPI.findAccount(recipient) != null){
            if(bankAPI.findAccount(sender).getBalance() >= amount){
                bankAPI.updateBalance(sender, -1 * amount);
                bankAPI.updateBalance(recipient, amount);
                System.out.println("Transaction was Successful.");
            } else {
                System.out.println("Insufficient Balance, Couldn't Complete the Action.");
            }
        } else {
            System.out.println("Invalid Mobile Number or this Number is not Associated with a Bank Account");
        }
    }

//    public static void main(String[] args) {
//        Account account1 = new BankAccount("acc1", "01111", 150.0);
//        Account account2 = new BankAccount("acc2", "02222", 70.0);
//        BankAPI.getInstance().addAccount(account1);
//        BankAPI.getInstance().addAccount(account2);
//        User user1 = new User("youssef", "01111", "xy", account1, UserType.BANK_USER);
//        User user2 = new User("maged", "02222", "xy", account2, UserType.BANK_USER);
//        System.out.println("Before transaction: " + user1.getBalance() + "   " + user2.getBalance());
//        BankTransfer bankTransfer = new BankTransfer();
//        TransferProcessor transferProcessor = new TransferProcessor();
//        transferProcessor.setTransfer(bankTransfer);
//        transferProcessor.makeTransfer("01111", "02222", 80.0);
//        System.out.println("After transaction: " + user1.getBalance() + "   " + user2.getBalance());
//    }
}
