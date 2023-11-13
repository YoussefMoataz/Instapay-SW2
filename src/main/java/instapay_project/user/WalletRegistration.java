package instapay_project.user;

import instapay_project.account.Account;
import instapay_project.api.APIFacade;

public class WalletRegistration extends Registration {


    @Override
    public UserType getUserType() {
        return UserType.WALLET_USER;
    }

    @Override
    public Account verify(String mobileNumber) {
        APIFacade api = new APIFacade();
        Account acc = api.getAccount(UserType.WALLET_USER, mobileNumber);
        return acc;
    }
}
