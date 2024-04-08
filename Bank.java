import java.util.*;

public class Bank {
    private List<User> users = new ArrayList<>();

   
    public void addUser(User user) {
        users.add(user);
    }

    public User getUser(int accountNumber, int pin) {
        for (User user : users) {
            if (user.getAccountNumber() == accountNumber && user.getPin() == pin) {
                return user;
            }
        }
        return null; 
    }
}