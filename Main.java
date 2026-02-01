import java.util.Scanner;
import service.AuthService;

public class Main {

     public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        AuthService auth = new AuthService();

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println("Choice:");

            int choice  = sc.nextInt();
            sc.nextLine();
            if (choice ==1) {
                System.out.println("Username: ");
                String user = sc.nextLine();

                System.out.print("EMAIL: ");
                String email = sc.nextLine();

                System.out.print("Password: ");
                String pass = sc.nextLine();

                System.out.print("Role (ADMIN/USER): ");
                String role = sc.nextLine();

                boolean success = auth.register(user, email,pass, role);
                System.out.println(success ? "Registered Successfully" : "Registration Failed");
                
                
                
            }else if (choice == 2) {
                System.out.print("Username: ");
                String user = sc.nextLine();

                System.out.print("Password: ");
                String pass = sc.nextLine();

                String role = auth.login(user, pass);

                if (role != null) {
                    System.out.println("Login Successful!");
                    System.out.println("Welcome " + role);
                } else {
                    System.out.println("Invalid Credentials");
                }
                
            } else {
                System.out.println("Thank You!");
                break;
            }
        
           
        }

 sc.close();

     }
}