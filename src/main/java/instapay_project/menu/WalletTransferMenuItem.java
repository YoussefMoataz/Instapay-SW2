package instapay_project.menu;

public class WalletTransferMenuItem implements MenuItem {
    @Override
    public void printCommand() {
        System.out.println("Transfer to Wallet using the mobile number");
    }

    @Override
    public void doAction() {
        // todo transfer
    }
}

