import java.io.*;
import java.lang.invoke.StringConcatFactory;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class BankSystem {
    private static final String FILE_NAME = "users.db";
    private Map<String,User> users;
    private Scanner sc = new Scanner(System.in);

    public BankSystem(){
        users = loadData();
    }

    @SuppressWarnings("unchecked")
    private Map<String,User> loadData(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))){
            return (Map<String,User>) ois.readObject();
        } catch(Exception e){
            return new HashMap<>();
        }
    }
    private void saveDate(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
            oos.writeObject(users);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error Saving Data. ");
        }
    }

    public void register(){
        System.out.println("Choose Username : ");
        String username = sc.nextLine();

        if(users.containsKey(username)){
            System.out.println("User Already Exists !");
            return;
        }
        System.out.println("Choose Password : ");
        String password = sc.nextLine();
        String hash = Utils.hashPassword(password);

        users.put(username, new User(username,hash));
        saveDate();

        System.out.println("Registration Successful ! ");
    }

    public User login(){
        System.out.println("Username : ");
        String username = sc.nextLine();

        if(!users.containsKey(username)){
            System.out.println("User Not Found !");
            return null;
        }
        System.out.println("Password: ");
        String password = sc.nextLine();
        String hash = Utils.hashPassword(password);

        if(!hash.equals(users.get(username).getPasswordHash())){
            System.out.println("Wrong Password ! ");
            return null;
        }

        System.out.println("Login Successfull ! ");
        return users.get(username);
    }
    public void deposit(User user){
        System.out.println("Enter Deposit Amount : ");
        double amt = sc.nextDouble();
        sc.nextLine();

        if(amt<=0){
            System.out.println("Amount Must be Positive");
            return;
        }
        user.deposit(amt);
        System.out.println(BankSystem.deposit());
        saveDate();
        System.out.println("Deposited Successfully ! ");

    }
    public void withdraw(User user){
        System.out.print("Enter Withdraw Amount : ");
        double amt= sc.nextDouble();
        sc.nextLine();

        if(!user.withdraw(amt)){
            System.out.println("Insufficient Balance ! ");
            return;
        }
        saveDate();
        System.out.println("Withdraw Successful. " );
    }
    public void checkBalance(User user){
        System.out.println("Your Balance : " + user.getBalance());

    }
    public void showTransactions(User user ){
        System.out.println("Transactions History : ");
        for (String t  : user.getTransactions()){
            System.out.println(" - "+t);
        }
    }
}
