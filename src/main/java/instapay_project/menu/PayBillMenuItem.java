package instapay_project.menu;

import instapay_project.InstapayManager;
import instapay_project.bills.BillPaymentProcessor;

public class PayBillMenuItem implements MenuItem {

    String command = "Pay bills";

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
        new BillPaymentProcessor(InstapayManager.getInstance().getCurrentUser()).showAllBills();
    }
}

