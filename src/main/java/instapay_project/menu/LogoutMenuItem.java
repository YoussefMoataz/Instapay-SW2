package instapay_project.menu;

import instapay_project.InstapayManager;

public class LogoutMenuItem implements MenuItem{

    String command = "Logout";

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
        InstapayManager.getInstance().logout();
    }
}
