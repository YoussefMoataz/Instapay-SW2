package instapay_project.bills;


public class WaterBill extends Bill {
    Double cubicMeters;
    Double meterPrice;

    WaterBill(String userName, Double vat, String supplier, String month, Double cubicMeters, Double meterPrice) {
        super(userName, vat, supplier, month);
        this.cubicMeters = cubicMeters;
        this.meterPrice = meterPrice;
    }

    @Override
    public String getDetails() {
        String details = "";
        details += (supplier + '\n');
        details += "--------------------------------------------\n";
        details += ("User: " + userName + '\n');
        details += ("For the Consumption of: " + month + '\n');
        details += (cubicMeters + " Cubic Meters Consumed Last Month.\n");
        details += ("Price per Cubic Meter: " + meterPrice + " egp.\n\n");
        details += ("Consumption: " + (cubicMeters * meterPrice) + " egp.\n");
        details += ("Taxes: " + vat + " egp.\n");
        details += ("Total: " + (cubicMeters * meterPrice + vat) + "egp.\n");

        return details;
    }

    @Override
    public Double getAmount() {
        return cubicMeters * meterPrice + vat;
    }

    public static void main(String[] args) {
        Bill bill = new WaterBill("Mohamed Maged", 15.0, "Cairo Water Supply Company", "November", 10.0, 5.0);
        System.out.println(bill.getDetails());
    }
}
