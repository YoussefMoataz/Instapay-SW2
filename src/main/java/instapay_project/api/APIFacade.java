package instapay_project.api;

import instapay_project.user.UserType;
import instapay_project.account.Account;

/**
 * @author Youssef Moataz
 */
public class APIFacade {

    /**
     * @param userType {@link UserType}
     * @param mobileNumber User mobile number to search with.
     * @return The found {@link Account}, null if not found.
     */
    public Account getAccount(UserType userType, String mobileNumber){

        if (userType == UserType.BANK_USER){
            return BankAPI.getInstance().findAccount(mobileNumber);
        } else if (userType == UserType.WALLET_USER) {
            return WalletProviderAPI.getInstance().findAccount(mobileNumber);
        }

        return null;
    }

}
