package instapay_project.user;

import instapay_project.account.Account;
import instapay_project.otp.OTPGenerator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class Registration {
     public User register(){
        String name = getName();
        String mobileNumber = getMobileNumber();
        if (handleOTP()) {

            Account account = verify(mobileNumber);
            if (account != null) {
                String password = getPassword();
                User user = new User(name, mobileNumber, password, account, getUserType());
                System.out.println("Registered successfully");
                return user;
            } else {
                System.out.println("this mobile number is not connected with a bank account");
                return null;
            }
        } else {
            System.out.println("Wrong OTP try again later");
            return null;
        }
    }

    public String getName() {
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username:");

        name = sc.nextLine();
        return name;
    }

    public String getMobileNumber() {
        boolean correctPhoneNumber = false;
        String phoneNumber = "";
        while (!correctPhoneNumber) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter phone number:");
            phoneNumber = sc.nextLine();
            if (phoneNumber.length() != 11) {
                correctPhoneNumber = false;
            } else if (phoneNumber.charAt(0) != '0') {
                correctPhoneNumber = false;
            } else if (phoneNumber.charAt(1) != '1') {
                correctPhoneNumber = false;
            } else if (phoneNumber.charAt(2) != '0' && phoneNumber.charAt(2) != '2' && phoneNumber.charAt(2) != '5' && phoneNumber.charAt(2) != '1') {
                correctPhoneNumber = false;
            } else {
                correctPhoneNumber = true;
            }

        }
        return phoneNumber;
    }
    abstract public UserType getUserType();

    public String getPassword() {
        boolean strongPassword = false;
        String password = "";
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        while (!strongPassword) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter password:");
            password = sc.nextLine();
            Matcher matcher = pattern.matcher(password);
            if (matcher.matches()) {
                strongPassword = true;
            }

        }
        return password;
    }

    public boolean handleOTP() {
        OTPGenerator otp = new OTPGenerator();
        String otpCode = otp.sendMeAnOTP(6);
        String userOTP;
        System.out.println("sent otp:" + otpCode);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter OTP:");
        userOTP = sc.nextLine();
        if (userOTP.equals(otpCode)) {
            return true;
        } else {
            return false;
        }

    }

    public abstract Account verify(String mobileNumber);
}
