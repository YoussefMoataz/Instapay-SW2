package instapay_project.menu;

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
        // todo bTP.showBills()
    }
}

