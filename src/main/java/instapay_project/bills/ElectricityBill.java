package instapay_project.bills;

public class ElectricityBill extends Bill{
    Integer kilowatts;
    Double wattPrice;

    ElectricityBill(String userName, Double vat, String supplier, String month, Integer kilowatts, Double wattPrice){
        super(userName, vat, supplier, month);
        this.kilowatts = kilowatts;
        this.wattPrice = wattPrice;
    }
    @Override
    public String getDetails() {
        String details = "";
        details += (supplier + '\n');
        details += "--------------------------------------------\n";
        details += ("User: " + userName + '\n');
        details += ("For the Consumption of: " + month + '\n');
        details += (kilowatts + " Kilowatts Consumed Last Month.\n");
        details += ("Price per Kilowatt: " + wattPrice + " egp.\n\n");
        details += ("Consumption: " + (kilowatts * wattPrice) + " egp.\n");
        details += ("Taxes: " + vat + " egp.\n");
        details += ("Total: " + (kilowatts * wattPrice + vat) + "egp.\n");

        return details;
    }

    @Override
    public Double getAmount() {
        return kilowatts * wattPrice + vat;
    }

    public static void main(String[] args) {
        Bill bill = new ElectricityBill("Mohamed Maged", 26.0, "Cairo Electricity Company", "November", 100, 2.5);
        System.out.println(bill.getDetails());
    }
}

