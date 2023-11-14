package instapay_project.menu;

import instapay_project.InstapayManager;
import instapay_project.api.BankAPI;
import instapay_project.transfers.BankTransfer;
import instapay_project.transfers.TransferProcessor;
import instapay_project.transfers.WalletTransfer;

import java.util.Scanner;

public class WalletTransferMenuItem implements MenuItem {

    String command = "Transfer to Wallet using the mobile number";

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
            transferProcessor.setTransfer(new WalletTransfer());
            transferProcessor.makeTransfer(InstapayManager.getInstance().getCurrentUser().getMobileNumber(), mobileNumber, amount);
        }

    }
}

