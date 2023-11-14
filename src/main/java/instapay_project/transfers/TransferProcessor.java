package instapay_project.transfers;

public class TransferProcessor {
    Transfer currentTransfer;

    public void setTransfer(Transfer transfer) {
        currentTransfer = transfer;
    }

    public void makeTransfer(String sender, String recipient, Double amount){
        currentTransfer.makeTransfer(sender, recipient, amount);
    }
}
