package instapay_project.menu;

public class InstapayTransferMenuItem implements MenuItem{
    @Override
    public void printCommand() {
        System.out.println("Transfer to Another instapay account");
    }

    @Override
    public void doAction() {
        // todo transfer
    }
}

