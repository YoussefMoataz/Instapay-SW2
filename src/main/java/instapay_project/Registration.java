package instapay_project;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class Registration {
    abstract public User register();
    public String getName(){
        String name;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter username:");

        name = sc.nextLine();
        return name;
    }
    public String getMobileNumber(){
        boolean correctPhoneNumber=false;
        String phoneNumber="";
        while(!correctPhoneNumber){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter phone number:");
            phoneNumber = sc.nextLine();
            if(phoneNumber.length()!=11){
                correctPhoneNumber=false;
            }else if(phoneNumber.charAt(0)!='0'){
                correctPhoneNumber=false;
            } else if (phoneNumber.charAt(1)!='1') {
                correctPhoneNumber=false;
            } else if (phoneNumber.charAt(2)!='0'&&phoneNumber.charAt(2)!='2' &&phoneNumber.charAt(2)!='5') {
                correctPhoneNumber=false;
            }else{
                correctPhoneNumber=true;
            }

        }
        return phoneNumber;
    }
    public String getPassword(){
        boolean strongPassword=false;
        String password="";
        String regex="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern pattern=Pattern.compile(regex);
        while(!strongPassword){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter phone number:");
            password = sc.nextLine();
            Matcher matcher=pattern.matcher(password);
            if(matcher.matches()){
                strongPassword=true;
            }

        }
        return password;
    }
}
