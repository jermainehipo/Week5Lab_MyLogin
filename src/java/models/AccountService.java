package models;

/**
 *
 * @author jerma
 */
public class AccountService {
    
    User user1;
    User user2;

    public AccountService() {
        user1 = new User("abe", "password");
        user2 = new User("barb", "password");
    }
    
    public User login(String username, String password) {
        if(username.equals("abe") && password.equals(user1.getPassword())) {
            return user1;
        } else if(username.equals("barb") && password.equals(user1.getPassword())) {
            return user2;
        } else {
            return null;
        }
    }
}
