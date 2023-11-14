package instapay_project.bills;


public abstract class Bill {
    String userName;
    Double vat;
    String supplier;
    String month;

    Bill(String userName, Double vat, String supplier, String month){
        this.userName = userName;
        this.vat = vat;
        this.supplier = supplier;
        this.month = month;
    }
    public abstract String getDetails();
    public abstract Double getAmount();
}
