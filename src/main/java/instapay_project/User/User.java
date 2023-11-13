package instapay_project.User;

public class User {
    String userName;
    String mobileNumber;
    String password;
    //Account account;
    UserType userType;

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
        //waiting for api
        return 0;
    }

}
