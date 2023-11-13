package instapay_project;

import instapay_project.user.BankRegistration;
import instapay_project.user.Registration;
import instapay_project.user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class InstapayManager {
    private ArrayList<User> users;
    private User currentUser;
    InstapayManager(){
        users=new ArrayList<User>();
        currentUser=null;
    }
    public boolean login(){
        String inputedUserName;
        String inputedPassword;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username:");
        inputedUserName = sc.nextLine();
        System.out.println("Enter password:");
        inputedPassword= sc.nextLine();
        currentUser=null;
        for(User a:users){
            if(a.getUserName().equals(inputedUserName)){
                if(a.getPassword().equals(inputedPassword)){
                    currentUser=a;
                    System.out.println("logged in successfully");
                }else{
                    System.out.println("wrong password or username");
                }
                break;
            }
        }
        if(currentUser==null){
            System.out.println("user not found");
            return false;
        }else{
            return true;
        }

    }
    public boolean registerUser(){

        String choice="";
        while (choice!="1"||choice!="2") {
            System.out.println("1-Bank account user");
            System.out.println("2-wallet user");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextLine();
            Registration r;
            if (choice.equals("1")) {
                r = new BankRegistration();
            } else if (choice.equals("2")) {
                r = new BankRegistration();
            } else {
                System.out.println("choose either 1 or 2");
                continue;
            }
            User user=r.register();
            if(user!=null){
                users.add(user);
                return true;
            }
        }
            return false;
    }

}
