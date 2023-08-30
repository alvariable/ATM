public class Account {
    double balance;
    String email;

    public Account(String email, double balance) {
        this.email = email;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    private void depositeMoney(double amount) {
        balance += amount;
    }

    private void withdrawMoney(double amount) {
        balance -= amount;
    }

    public boolean transferMoney(double amount, Account rec) {
        if (amount > balance)
            return false;
        else {
            withdrawMoney(amount);
            rec.depositeMoney(amount);
            return true;
        }
    }

}
