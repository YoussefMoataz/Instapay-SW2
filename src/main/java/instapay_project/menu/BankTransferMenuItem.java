package instapay_project.menu;

public class BankTransferMenuItem implements MenuItem {

    String command = "Transfer to Bank account using account number";

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

