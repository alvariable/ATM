import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;

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

    public double depositMoney(String email, double balance) {
        if (balance < 0)
            return -1.0;
        // creates hashCode for email
        int ID = getUserID(email);
        // checks if hashCode key exists
        if (!bankAccounts.containsKey(ID))
            // if !exists -> return false
            return -1.0;
        // else -> add balance to account
        double temp = bankAccounts.get(ID);
        temp += balance;
        bankAccounts.put(ID, temp);
        return balance;
    }

    public double withdrawMoney(String email, double balance) {
        if (balance < 0)
            return -1.0;
        // creates hashCode for email
        int ID = getUserID(email);
        // checks if hashCode key exists
        if (!bankAccounts.containsKey(ID))
            // if !exists -> return false
            return -1.0;
        // else -> add balance to account
        double temp = bankAccounts.get(ID);
        temp -= balance;
        if (temp < 0)
            return -1.0;
        bankAccounts.put(ID, temp);
        return balance;
    }

    public boolean transferMoney(String emailA, String emailB, double balance) {
        if (balance < 0)
            return false;
        // creates hashCode for email
        int IDa = getUserID(emailA);
        int IDb = getUserID(emailB);
        // checks if hashCode key exists
        if (!bankAccounts.containsKey(IDa) || !bankAccounts.containsKey(IDb))
            // if either acc !exist(s) -> return false
            return false;
        // else -> add balance to account
        double temp = bankAccounts.get(IDa);
        temp -= balance;
        if (temp < 0)
            return false;
        bankAccounts.put(IDa, temp);
        temp = bankAccounts.get(IDb);
        temp += balance;
        bankAccounts.put(IDb, temp);
        return true;
    }

    public double checkBalance(String email) {
        // creates hashCode for email
        int ID = getUserID(email);
        // checks if hashCode key exists
        if (!bankAccounts.containsKey(ID))
            // if !exists -> return false
            return -1.0;
        // else -> return current balance of account
        return bankAccounts.get(ID);
    }

    public void audit() throws IOException {
        FileOutputStream fos = new FileOutputStream(
                "/Users/ardendoyle/Documents/personal/coding/Honors Topics/ATM/AccountAudit.txt");
        File file = new File("/Users/ardendoyle/Documents/personal/coding/Honors Topics/ATM/AccountAudit.txt");
        PrintWriter pw = new PrintWriter(file);
        Set<Integer> keySet = bankAccounts.keySet();
        for (Integer k : keySet) {
            pw.println(k);
            pw.println(bankAccounts.get(k) + "");
        }
        pw.close();
        fos.close();
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