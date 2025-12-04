import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        BankSystem bank = new BankSystem();

        while (true) {
            System.out.println("\n=== Banking App ===");
            System.out.println("1. Register ");
            System.out.println("2. Login ");
            System.out.println("3. Exit ");
            System.out.println("Choose : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> bank.register();
                case 2 -> {
                    User user = bank.login();
                    if(user != null) userMenu(bank,user,sc);
                }                    
                case 3 ->{
                    System.out.println("GoodBye !");
                    return;
                }
                default -> System.out.println("Invalid !");
            }
        }
    }
    private static void userMenu(BankSystem bank, User user , Scanner sc){
        while (true) {
            System.out.println("\n === Welcome " +user.getUsername()+ " ===");
            System.out.println("1. Deposit ");
            System.out.println("2. Withdraw ");
            System.out.println("3. Check Balance ");
            System.out.println("4. Transactions ");
            System.out.println("5. Logout ");
            System.out.println(" Choose : ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    bank.deposit(user);
                    break;

                case 2:
                    bank.withdraw(user);
                    break;

                case 3:
                    bank.checkBalance(user);
                    break;

                case 4:
                    bank.showTransactions(user);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
            
        }
    }
}
