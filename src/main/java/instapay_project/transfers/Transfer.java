package instapay_project.transfers;

public interface Transfer {
    public void makeTransfer(String sender, String recipient, Double amount);
}
