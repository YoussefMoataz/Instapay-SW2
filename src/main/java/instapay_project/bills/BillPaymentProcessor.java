package instapay_project.bills;

import instapay_project.InstapayManager;
import instapay_project.account.Account;
import instapay_project.account.BankAccount;
import instapay_project.api.BankAPI;
import instapay_project.api.WalletProviderAPI;
import instapay_project.user.User;
import instapay_project.user.UserType;

import java.util.ArrayList;
import java.util.Scanner;

public class BillPaymentProcessor {
    ArrayList<Bill> bills = null;
    Bill currentBill = null;

    public BillPaymentProcessor(User user){
        bills = new ArrayList<Bill>();
        bills.add(new ElectricityBill(user.getUserName(), 26.0, "Cairo Electricity Company", "November", 100, 2.5));
        bills.add(new WaterBill(user.getUserName(), 11.5, "Cairo Company for Water Supply", "November", 18.5, 3.75));
        bills.add(new GasBill(user.getUserName(), 18.0, "Cairo Natural Gas Company", "November", 10.0, 1.5));
    }

    public void showAllBills(){
        for(int i = 0; i < bills.size(); i++){
            System.out.println((i+1) + "- " + bills.get(i).getDetails());
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Do You Want to Continue (y/n)? ");
        if(scanner.nextLine().equalsIgnoreCase("y")){
            System.out.print("Please Choose a Bill Number: ");
            String choice = scanner.nextLine();
            if(Integer.parseInt(choice) <= bills.size() && Integer.parseInt(choice) >= 1){
                currentBill = bills.get(Integer.parseInt(choice) - 1);
                System.out.println("==================================");
                System.out.println(currentBill.getDetails());
                System.out.println("==================================");
                System.out.print("Do You Confirm this Action (y/n)? ");
                if(scanner.nextLine().equalsIgnoreCase("y")){
                    pay();
                } else {
                    System.out.println("Operation Canceled.");
                }
            } else {
                boolean flag = true;
                System.out.println("Invalid Choice.");
                do{
                    System.out.print("Please Choose a Bill Number: ");
                    choice = scanner.nextLine();
                    if(Integer.parseInt(choice) <= bills.size() && Integer.parseInt(choice) >= 1){
                        currentBill = bills.get(Integer.parseInt(choice) - 1);
                        flag = false;
                        System.out.println("==================================");
                        System.out.println(currentBill.getDetails());
                        System.out.println("==================================");
                        System.out.print("Do You Confirm this Action (y/n)? ");
                        if(scanner.nextLine().equalsIgnoreCase("y")){
                            pay();
                        } else {
                            System.out.println("Operation Canceled.");
                        }
                    } else {
                        System.out.println("Invalid Choice, do you want to continue (y/n)?");
                        if(!scanner.nextLine().equalsIgnoreCase("y")){
                            flag = false;
                        }
                    }
                } while(flag);
            }
        }
    }

    public void pay(){
        if(InstapayManager.getCurrentUser().getUserType() == UserType.BANK_USER){
            Account currentUserAccount = BankAPI.getInstance().findAccount(InstapayManager.getCurrentUser().getMobileNumber());
            if(currentUserAccount.getBalance() >= currentBill.getAmount()){
                BankAPI.getInstance().updateBalance(currentUserAccount.getMobileNumber(), -1 * currentBill.getAmount());
                System.out.println("Bill Payed Successfully");
            } else {
                System.out.println("Insufficient Balance, Couldn't Complete Action");
            }
        } else {
            Account currentUserAccount = WalletProviderAPI.getInstance().findAccount(InstapayManager.getCurrentUser().getMobileNumber());
            if(currentUserAccount.getBalance() >= currentBill.getAmount()){
                WalletProviderAPI.getInstance().updateBalance(currentUserAccount.getMobileNumber(), -1 * currentBill.getAmount());
                System.out.println("Bill Payed Successfully");
            } else {
                System.out.println("Insufficient Balance, Couldn't Complete Action");
            }
        }
    }

//    public static void main(String[] args) {
//        Account account = new BankAccount("1111", "", 150.0);
//        User user = new User("mohamed maged", "", "", account, UserType.BANK_USER);
//        InstapayManager.setCurrentUser(user);
//        BankAPI.getInstance().addAccount(account);
//        System.out.println("Before Transaction: " + InstapayManager.getCurrentUser().getBalance());
//        BillPaymentProcessor b = new BillPaymentProcessor(InstapayManager.getCurrentUser());
//        b.showAllBills();
//        System.out.println("After Transaction: " + InstapayManager.getCurrentUser().getBalance());
//    }
}
