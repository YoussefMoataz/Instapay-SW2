package instapay_project.menu;

import instapay_project.InstapayManager;
import instapay_project.user.User;

public class BalanceInquiryMenuItem implements MenuItem {

    String command = "Check my balance";

    @Override
    public void printCommand() {
        System.out.println(command);
    }

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public void doAction() {

        User user = InstapayManager.getCurrentUser();

        if (user != null) {
            System.out.println(user.getUserName() + " has balance: " + user.getBalance());
        } else {
            System.out.println("An error has occurred while retrieving balance.");
        }

    }
}
