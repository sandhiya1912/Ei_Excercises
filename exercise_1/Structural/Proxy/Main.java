package exercise_1.Structural.Proxy;

import exercise_1.Structural.Proxy.Real_Service.*;
import exercise_1.Structural.Proxy.Proxy_Service_Logging_Security.ProxyBankService;
import exercise_1.Structural.Proxy.model.UserBank;
import exercise_1.Utils.TransientException;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RealBankService realBank = new RealBankService();
        realBank.addUser(new UserBank(1, "sandhiya", "1234", 1000));
        realBank.addUser(new UserBank(2, "jasmine", "5678", 500));

        ProxyBankService proxy = new ProxyBankService(realBank);
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("Enter bank requests (type 'END' to stop):");

        while(running){
            System.out.print("Request type (deposit/withdraw/end): ");
            String Type = sc.nextLine().trim().toLowerCase();
            if (Type.equals("end")){
                System.out.println("Bank service closed..");
                break;
            }

            try {
                System.out.print("User ID: ");
                int UserId = Integer.parseInt(sc.nextLine().trim());

                System.out.print("PIN: ");
                String Pin = sc.nextLine().trim();

                System.out.print("Amount: ");
                double Amount = Double.parseDouble(sc.nextLine().trim());

                try {
                    switch (Type) {
                        case "deposit":
                            proxy.deposit(UserId, Pin, Amount);
                            break;
                        case "withdraw":
                            proxy.withdraw(UserId, Pin, Amount);
                            break;
                        default:
                            System.out.println("Unknown request type: " + Type);
                    }
                } catch (TransientException te) {
                    System.out.println("Transient error for UserId=" + UserId + " → " + te.getMessage());
                    Thread.sleep(2000);
                    System.out.println("Retry after some time...");
                } catch (Exception e) {
                    System.out.println("Error (UserId=" + UserId + "): " + e.getMessage());
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid number input. Please enter numeric User ID and Amount.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}
