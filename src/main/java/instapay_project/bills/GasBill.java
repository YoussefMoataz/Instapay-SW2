package instapay_project.bills;

public class GasBill extends Bill{
    Double cubicMeters;
    Double meterPrice;

    GasBill(String userName, Double vat, String supplier, String month, Double cubicMeters, Double meterPrice){
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
}
