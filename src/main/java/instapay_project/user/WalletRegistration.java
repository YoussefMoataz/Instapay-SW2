package instapay_project.user;

import instapay_project.account.Account;
import instapay_project.api.APIFacade;

public class WalletRegistration extends Registration {

    @Override
    public User register() {
        String name = getName();
        String mobileNumber = getMobileNumber();
        if (handleOTP()) {
            Account account = verify(mobileNumber);
            if (account != null) {
                String password = getPassword();
                User user = new User(name, mobileNumber, password, account, UserType.WALLET_USER);
                System.out.println("Registered successfully");
                return user;
            } else {
                System.out.println("this mobile number is not connected with a Wallet provider");
                return null;
            }
        } else {
            System.out.println("Wrong OTP try again later");
            return null;
        }
    }

    @Override
    public Account verify(String mobileNumber) {
        APIFacade api = new APIFacade();
        Account acc = api.getAccount(UserType.WALLET_USER, mobileNumber);
        return acc;
    }
}
