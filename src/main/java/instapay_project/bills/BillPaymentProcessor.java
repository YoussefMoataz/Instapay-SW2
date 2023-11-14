package instapay_project.bills;

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
            if(Integer.parseInt(choice) <= 9 && Integer.parseInt(choice) >= 1){
                currentBill = bills.get(Integer.parseInt(choice));
            } else {
                boolean flag = true;
                System.out.println("Invalid Choice.");
                do{
                    System.out.print("Please Choose a Bill Number: ");
                    choice = scanner.nextLine();
                    if(Integer.parseInt(choice) <= 9 && Integer.parseInt(choice) >= 1){
                        currentBill = bills.get(Integer.parseInt(choice));
                        flag = false;
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

    }

//    public static void main(String[] args) {
//        BillPaymentProcessor b = new BillPaymentProcessor(new User("mohamed maged", "", "", null, UserType.BANK_USER));
//        b.showAllBills();
//    }
}
