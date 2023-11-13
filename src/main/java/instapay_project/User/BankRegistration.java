package instapay_project.User;

import instapay_project.account.Account;
import instapay_project.api.BankAPI;

public class BankRegistration extends Registration{
    @Override
    public User register() {
        String name=getName();
        String mobileNumber =getMobileNumber();
        Account account =verify(mobileNumber);
        if(account!=null){
            String password=getPassword();
             User user = new User(name, mobileNumber, password, account, UserType.Bank_User);
             return user;
        }else{
            System.out.println("this mobile number is not connected with a bank account");
            return null;
        }
    }

    @Override
    public Account verify(String mobileNumber) {
        return BankAPI.getInstance().findAccount(mobileNumber);
    }
}
