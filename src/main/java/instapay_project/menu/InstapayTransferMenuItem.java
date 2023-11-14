package instapay_project.menu;

public class InstapayTransferMenuItem implements MenuItem {

    String command = "Transfer to Another instapay account";

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
        // todo transfer
    }
}

