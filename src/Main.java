import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Corrected: Ensure the variable name matches (sc)
        Scanner sc = new Scanner(System.in);
        Login auth = new Login();

        System.out.println("--- Registration ---");
        System.out.print("First Name: ");
        String fName = sc.nextLine();

        System.out.print("Last Name: ");
        String lName = sc.nextLine();

        // Fixed: Changed 'scanner' to 'sc' to match the declaration above
        System.out.print("Enter Username (e.g., kyl_1): ");
        String user = sc.nextLine();

        System.out.print("Enter Password (e.g., Ch&&sec@ke99!): ");
        String pass = sc.nextLine();

        System.out.print("Enter Cell (e.g., +27838968976): ");
        String cell = sc.nextLine();

        // Register and show message
        String regMessage = auth.registerUser(user, pass, fName, lName, cell);
        System.out.println("\n" + regMessage);

        // If registration was successful, try logging in
        if (regMessage.contains("successfully captured")) {
            System.out.println("\n--- Login ---");
            System.out.print("Username: ");
            String loginUser = sc.nextLine();

            System.out.print("Password: ");
            String loginPass = sc.nextLine();

            boolean success = auth.loginUser(loginUser, loginPass);
            System.out.println(auth.returnLoginStatus(success));
        }

        sc.close(); // Good practice to close the scanner
    }
}