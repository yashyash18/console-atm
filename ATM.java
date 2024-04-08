public class ATM {
    private Bank bank;

    public ATM(Bank bank) {
        this.bank = bank;
    }

    public boolean login(int accountNumber, int pin) {
        return bank.getUser(accountNumber, pin) != null;
    }

    public double checkBalance(int accountNumber, int pin) {
        User user = bank.getUser(accountNumber, pin);
        if (user != null) {
            return user.getBalance();
        }
        return -1; // User not found
    }

    public boolean deposit(int accountNumber, int pin, double amount) {
        User user = bank.getUser(accountNumber, pin);
        if (user != null) {
            user.deposit(amount);
            return true;
        }
        return false; // User not found
    }

    public boolean withdraw(int accountNumber, int pin, double amount) {
        User user = bank.getUser(accountNumber, pin);
        if (user != null) {
            return user.withdraw(amount);
        }
        return false; // User not found
    }
}

// 