package instapay_project.otp;

import java.util.Random;

/**
 * @author Youssef Moataz
 */
public class OTPGenerator {

    /**
     * This is used for offline OTP generation.
     *
     * @param length The length of the required OTP.
     * @return A string of generated random numbers.
     * @author Youssef Moataz
     */
    public String sendMeAnOTP(Integer length) {

        StringBuilder otp = new StringBuilder();

        for (int i = 0; i < length; i++) {

            otp.append(new Random().nextInt(10));

        }

        return otp.toString();

    }

}
