package instapay_project.menu;

public class WalletTransferMenuItem implements MenuItem {

    String command = "Transfer to Wallet using the mobile number";

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

