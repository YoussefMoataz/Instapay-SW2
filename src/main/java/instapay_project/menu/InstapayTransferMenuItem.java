package instapay_project.menu;

import instapay_project.InstapayManager;
import instapay_project.api.InstapayAPI;
import instapay_project.transfers.InstapayTransfer;
import instapay_project.transfers.TransferProcessor;

import java.util.Scanner;

public class InstapayTransferMenuItem implements MenuItem {

    String command = "Transfer to Another instapay account";

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

        System.out.println("Enter recipient username:");
        String username = new Scanner(System.in).nextLine();

        if (InstapayAPI.getInstance().getUser(username) != null){

            System.out.println("Enter amount to be sent:");
            Double amount = new Scanner(System.in).nextDouble();

            TransferProcessor transferProcessor = new TransferProcessor();
            transferProcessor.setTransfer(new InstapayTransfer());
            transferProcessor.makeTransfer(InstapayManager.getCurrentUser().getUserName(), username, amount);
        }

    }
}

