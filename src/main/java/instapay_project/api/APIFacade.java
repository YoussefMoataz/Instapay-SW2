package instapay_project.api;

import instapay_project.User.UserType;
import instapay_project.account.Account;

public class APIFacade {

    public Account getAccount(UserType userType, String mobileNumber){

        if (userType == UserType.BANK_USER){
            BankAPI.getInstance().findAccount(mobileNumber);
        } else if (userType == UserType.WALLET_USER) {
            WalletProviderAPI.getInstance().findAccount(mobileNumber);
        }

        return null;
    }

}
