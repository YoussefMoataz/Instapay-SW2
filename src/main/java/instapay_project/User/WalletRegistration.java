package instapay_project.User;

import instapay_project.account.Account;
import instapay_project.api.BankAPI;
import instapay_project.api.WalletProviderAPI;

public class WalletRegistration extends Registration {

    @Override
    public User register() {
        String name=getName();
        String mobileNumber =getMobileNumber();
        Account account =verify(mobileNumber);
        if(account!=null){
            String password=getPassword();
            User user = new User(name, mobileNumber, password, account, UserType.Wallet_User);
            return user;
        }else{
            System.out.println("this mobile number is not connected with a Wallet provider");
            return null;
        }
    }

    @Override
    public Account verify(String mobileNumber) {
        return WalletProviderAPI.getInstance().findAccount(mobileNumber);
    }
}
