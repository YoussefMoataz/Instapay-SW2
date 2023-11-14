package instapay_project;

import instapay_project.api.InstapayAPI;
import instapay_project.menu.*;
import instapay_project.user.BankRegistration;
import instapay_project.user.Registration;
import instapay_project.user.User;
import instapay_project.user.UserType;

import java.util.ArrayList;
import java.util.Scanner;

public class InstapayManager {
    private static InstapayManager instance;
    private static ArrayList<User> users;
    private static ArrayList<MenuItem> menuItems;
    private static User currentUser;

    private InstapayManager() {
    }

    public static InstapayManager getInstance() {
        if (instance == null) {
            instance = new InstapayManager();
            users = InstapayAPI.getInstance().getUsers();
            menuItems = new ArrayList<>();
            currentUser = null;
        }
        return instance;
    }

    private static boolean loginUser() {
        String inputedUserName;
        String inputedPassword;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username:");
        inputedUserName = sc.nextLine();
        System.out.println("Enter password:");
        inputedPassword = sc.nextLine();
        currentUser = null;
        for (User a : users) {
            if (a.getUserName().equals(inputedUserName)) {
                if (a.getPassword().equals(inputedPassword)) {
                    currentUser = a;
                    System.out.println("logged in successfully");
                } else {
                    System.out.println("wrong password or username");
                }
                break;
            }
        }
        if (currentUser == null) {
            System.out.println("user not found");
            return false;
        } else {
            return true;
        }

    }

    private static boolean registerUser() {

        String choice = "";
        while (choice != "1" || choice != "2") {
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
            User user = r.register();
            if (user != null) {
                users.add(user);
                return true;
            }
        }
        return false;
    }

    public void logout() {
        currentUser = null;
        System.out.println("Logged out!");
        showMainMenu();
    }

    public User getCurrentUser() {
        return currentUser;
    }

    private void buildMenu() {

        menuItems.clear();

        if (currentUser != null) {
            if (currentUser.getUserType() == UserType.BANK_USER) {
                menuItems.add(new WalletTransferMenuItem());
                menuItems.add(new BankTransferMenuItem());
                menuItems.add(new InstapayTransferMenuItem());
                menuItems.add(new BalanceInquiryMenuItem());
                menuItems.add(new PayBillMenuItem());
            } else if (currentUser.getUserType() == UserType.WALLET_USER) {
                menuItems.add(new WalletTransferMenuItem());
                menuItems.add(new InstapayTransferMenuItem());
                menuItems.add(new BalanceInquiryMenuItem());
                menuItems.add(new PayBillMenuItem());
            }
            menuItems.add(new LogoutMenuItem());
        }

    }

    private void showUserMenu() {

        buildMenu();

        while (true) {

            System.out.println("Choose action:");
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println((i + 1) + "- " + menuItems.get(i).getCommand());
            }

            Integer choice = new Scanner(System.in).nextInt();

            if (choice > 0 && choice <= menuItems.size()) {
                menuItems.get(choice - 1).doAction();
            } else {
                System.out.println("Invalid action");
            }

        }

    }

    private void showMainMenu() {
        Integer choice;
        while (true) {

            System.out.println("""
                    Choose action:
                    1- Register
                    2- Login
                    0- Exit""");

            choice = new Scanner(System.in).nextInt();

            if (choice == 0) {
                System.exit(0);
            } else if (choice == 1) {
                break;
            } else if (choice == 2) {
                break;
            } else {
                System.out.println("Invalid action");
            }
        }

        if (choice == 1) {
            if (registerUser()) {
                showUserMenu();
            }
        } else if (choice == 2) {
            if (loginUser()) {
                showUserMenu();
            }
        }

    }

    public void run() {

        System.out.println("Welcome to Instapay!");

        showMainMenu();

    }

}

