import java.util.HashMap;

public class ATM {
    // creates a static hashmap that holds the accounts
    // key: userID, value: balance

    HashMap<Integer, Double> bankAccounts = new HashMap<Integer, Double>();

    public boolean openAccount(String email, double balance) {
        // creates hashCode for email
        int ID = getUserID(email);
        // checks if hashCode key exists
        if (bankAccounts.containsKey(ID))
            // if exists -> return false
            return false;
        else
            // else -> add new key, value to the hashmap, return true;
            bankAccounts.put(ID, balance);
        return true;
    }

    public boolean closeAccount(String email) {
        // creates hashCode for email
        int ID = getUserID(email);
        // checks if hashCode key exists
        if (!bankAccounts.containsKey(ID))
            // if !exists -> return false
            return false;
        else
            // else -> remove account
            return true;
    }

    private int getUserID(String email) {
        return email.hashCode();
    }

    void audit() {
        // printsaccounts
    }

    public double depositMoney(String string, int i) {
        return 0.0;
    }

    public double withdrawMoney(String string, int i) {
        return 0.0;
    }

    public boolean transferMoney(String string, String string2, int amount) {
        return false;
    }

    public String checkBalance(String string) {
        return null;
    }
}

/*
 * public boolean closeAccount(int userID) {
 * // creates hashCode for email
 * // checks if hashCode key exists
 * // if exists -> rempve account, return true
 * // else -> return false
 * return false;
 * }
 * 
 * private double checkBalance(int userID) {
 * Account a = bankAccounts.get(userID);
 * return a.getBalance();
 * }
 * 
 * 
 * private double depositeMoney(int userID, double amount) {
 * if (exists(userID)) {
 * return 0.0;
 * }
 * return -1.0;
 * }
 * 
 * private double withdrawMoney(int userID) {
 * return 0.0;
 * }
 * 
 * private boolean transferMoney(int fromID, int toID, double amount) {
 * // checks to see if both accounts exist;
 * if (!bankAccounts.containsKey(fromID) || !bankAccounts.containsKey(toID))
 * return false;
 * Account a = bankAccounts.get(fromID);
 * Account b = bankAccounts.get(toID);
 * return a.transferMoney(amount, b);
 * }
 * private boolean exists(String email) {
 * return bankAccounts.containsKey(email.hashCode());
 * }
 */