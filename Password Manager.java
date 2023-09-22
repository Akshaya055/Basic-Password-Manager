import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PasswordManager {
    private static Map<String, String> passwordMap = new HashMap<>();
    private static final String MASTER_PASSWORD = "your_master_password"; // Replace with your master password

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;

        System.out.println("Welcome to the Password Manager!");

        while (true) {
            if (!loggedIn) {
                System.out.print("Enter master password: ");
                String masterPassword = scanner.nextLine();
                if (masterPassword.equals(MASTER_PASSWORD)) {
                    loggedIn = true;
                    System.out.println("Logged in successfully.");
                } else {
                    System.out.println("Invalid master password. Try again.");
                }
            } else {
                System.out.println("\nMenu:");
                System.out.println("1. Add a new password");
                System.out.println("2. Retrieve a password");
                System.out.println("3. Exit");

                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter account name: ");
                        String accountName = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String accountPassword = scanner.nextLine();
                        passwordMap.put(accountName, accountPassword);
                        System.out.println("Password added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter account name to retrieve password: ");
                        String retrieveAccount = scanner.nextLine();
                        String retrievedPassword = passwordMap.get(retrieveAccount);
                        if (retrievedPassword != null) {
                            System.out.println("Password: " + retrievedPassword);
                        } else {
                            System.out.println("Account not found.");
                        }
                        break;
                    case 3:
                        System.out.println("Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}
