package instapay_project.api;

import instapay_project.user.User;

import java.util.ArrayList;

public class InstapayAPI {

    private static InstapayAPI instance = null;
    private static ArrayList<User> users;

    private InstapayAPI() {
    }

    public static InstapayAPI getInstance() {
        if (instance == null) {
            instance = new InstapayAPI();
            users = new ArrayList<>();
        }
        return instance;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User getUser(String userName) {
        for (User u : users) {
            if (u.getUserName().equals(userName)) {
                return u;
            }
        }
        return null;
    }

    public void addUser(User user){
        users.add(user);
    }

}
