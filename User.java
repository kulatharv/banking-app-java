import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    
    private String username;
    private String passwordHash;
    private double balance;
    private List<String> transactions;

    public User(String username, String passwordHash){
        this.username= username;
        this.passwordHash = passwordHash;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    } 
    public String getUsername(){return username;}
    public String getPasswordHash(){return passwordHash;}
    public double getBalance(){return balance;}
    public List<String> getTransactions(){
        return transactions;
    }
    public void deposit(double amount){
        balance += amount;
        transactions.add("Deposited : "+amount);
    }
    public boolean withdraw(double amount){
        if(amount > balance) return false;
        balance -= amount;
        transactions.add("withdraw : "+amount);

        return true;
    }
}
