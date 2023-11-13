package instapay_project.menu;

public class BankTransferMenuItem implements MenuItem {
    @Override
    public void printCommand() {
        System.out.println("Transfer to Bank account using account number");
    }

    @Override
    public void doAction() {
        // todo transfer
    }
}

