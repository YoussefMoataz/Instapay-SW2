package instapay_project.User;

import instapay_project.account.Account;
import instapay_project.api.API;

public class User {
    String userName;
    String mobileNumber;
    String password;
    Account account;
    UserType userType;



    User(String userName,String mobileNumber,String password,Account account,UserType type){
        this.userName=userName;
        this.mobileNumber=mobileNumber;
        this.password=password;
        this.account=account;
        this.userType=type;

    }
    public String getUserName(){
        return userName;
    }
    public String getMobileNumber(){
        return mobileNumber;
    }
    public String getPassword(){
        return password;
    }
    public double getBalance(){

        return 0;
    }

}
