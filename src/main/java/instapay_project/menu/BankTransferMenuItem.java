package instapay_project.menu;

import instapay_project.InstapayManager;
import instapay_project.api.BankAPI;
import instapay_project.api.InstapayAPI;
import instapay_project.transfers.BankTransfer;
import instapay_project.transfers.InstapayTransfer;
import instapay_project.transfers.TransferProcessor;

import java.util.Scanner;

public class BankTransferMenuItem implements MenuItem {

    String command = "Transfer to Bank account using account number";

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

        System.out.println("Enter recipient mobile number:");
        String mobileNumber = new Scanner(System.in).nextLine();

        if (BankAPI.getInstance().findAccount(mobileNumber) != null) {
            System.out.println("Enter amount to be sent:");
            Double amount = new Scanner(System.in).nextDouble();

            TransferProcessor transferProcessor = new TransferProcessor();
            transferProcessor.setTransfer(new BankTransfer());
            transferProcessor.makeTransfer(InstapayManager.getCurrentUser().getMobileNumber(), mobileNumber, amount);
        }

    }
}

