package instapay_project.menu;

public class PayBillMenuItem implements MenuItem {
    @Override
    public void printCommand() {
        System.out.println("Transfer to Bank account using account number");
    }

    @Override
    public void doAction() {
        // todo bTP.showBills()
    }
}

