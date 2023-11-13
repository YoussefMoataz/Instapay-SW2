package instapay_project.menu;

public class BalanceInquiryMenuItem implements MenuItem {
    @Override
    public void printCommand() {
        System.out.println("Transfer to Bank account using account number");
    }

    @Override
    public void doAction() {
        // todo print balance
    }
}
