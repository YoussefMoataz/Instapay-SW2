package instapay_project.api;

import instapay_project.account.Account;
import instapay_project.user.UserType;

/**
 * @author Youssef Moataz
 */
public abstract class API {
    private String apiUrl;

    /**
     * @param mobileNumber The mobile number sent to the API request.
     * @return The {@link Account} with the entered mobile number, returns null if not found.
     */
    public abstract Account findAccount(String mobileNumber);

    /**
     * @param mobileNumber The mobile number sent to the API request.
     * @param amount Can be positive or negative to deposit or withdraw money to the account.
     * @return true if account exists, false otherwise.
     */
    public abstract boolean updateBalance(String mobileNumber, Double amount);

    /**
     * @param account The new account to be added
     */
    public abstract void addAccount(Account account);

}
