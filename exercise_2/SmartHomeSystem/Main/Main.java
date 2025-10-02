package exercise_2.SmartHomeSystem.Main;

import exercise_2.SmartHomeSystem.Proxy.SmartHomeProxy;
import exercise_2.SmartHomeSystem.Utils.AppLogger;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = AppLogger.getLogger();
    private final AtomicBoolean running = new AtomicBoolean(true);
    private final SmartHomeProxy proxyHub;

    public Main(boolean isAdmin) {
        this.proxyHub = new SmartHomeProxy(isAdmin);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        logger.info("Smart Home application started....!");

        System.out.println("Smart Home System");
        System.out.print("Are you admin or guest? ");
        String role = sc.nextLine();
        boolean isAdmin = role.equalsIgnoreCase("admin");

        if(isAdmin) logger.info("Admin entered the smart home system");
        else logger.info("Guest entered the smart home system");

        Main app = new Main(isAdmin);
        app.startService();
        sc.close();
    }

    public void startService() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\nSmart Home application stopped...");
            running.set(false);
        }));

        Scanner sc = new Scanner(System.in);
        while (running.get()) {
            System.out.println("\nSmart Home Hub Menu:");
            System.out.println("1. Add Device");
            System.out.println("2. Remove Device");
            System.out.println("3. Turn On Device");
            System.out.println("4. Turn Off Device");
            System.out.println("5. Configure Device");
            System.out.println("6. Set Schedule");
            System.out.println("7. Add Trigger");
            System.out.println("8. Show Status");
            System.out.println("9. Show Schedules");
            System.out.println("10. Show Triggers");
            System.out.println("11. Exit");

            System.out.print("Enter choice: ");
            String command = sc.nextLine();

            try {
                switch (command) {
                    case "1":
                        if (proxyHub.authenticate("add device")) break;
                        System.out.print("Enter device ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter device type (light/thermostat/door): ");
                        String type = sc.nextLine();
                        proxyHub.addDevice(id, type);
                        logger.info("Device added successfully: ID = " + id + ", Type=" + type);
                        break;
                    case "2":
                        if (proxyHub.authenticate("remove device")) break;
                        System.out.print("Enter device ID to remove: ");
                        int removeId = Integer.parseInt(sc.nextLine());
                        proxyHub.removeDevice(removeId);
                        logger.info("Device removed successfully: ID = " + removeId);
                        break;
                    case "3":
                        if (proxyHub.authenticate("turn on device")) break;
                        System.out.print("Enter device ID to turn on: ");
                        int turnonId = Integer.parseInt(sc.nextLine());
                        proxyHub.turnOn(turnonId);
                        logger.info("Device " + turnonId + " turned on successfully");
                        break;
                    case "4":
                        if (proxyHub.authenticate("turn off device")) break;
                        System.out.print("Enter device ID to turn off: ");
                        int turnoffId = Integer.parseInt(sc.nextLine());
                        proxyHub.turnOff(turnoffId);
                        logger.info("Device " + turnoffId + " turned off successfully");
                        break;
                    case "5":
                        if (proxyHub.authenticate("configure device")) break;
                        System.out.print("Enter device ID to configure: ");
                        int configId = Integer.parseInt(sc.nextLine());
                        proxyHub.configureDevice(configId);
                        logger.info("Device " + configId + " configured successfully");
                        break;
                    case "6":
                        if (proxyHub.authenticate("schedule device")) break;
                        System.out.print("Enter device ID for schedule: ");
                        int scheduleId = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter schedule time (e.g. 05:00): ");
                        String time = sc.nextLine();
                        System.out.print("Enter schedule command (turnOn/turnOff): ");
                        String cmd = sc.nextLine();
                        proxyHub.setSchedule(scheduleId, time, cmd);
                        logger.info("Device " + scheduleId + " scheduled successfully");
                        break;
                    case "7":
                        if (proxyHub.authenticate("adding trigger")) break;
                        System.out.print("Enter trigger condition(e.g. temperature > 75): ");
                        String condition = sc.nextLine();
                        System.out.print("Enter trigger action(e.g. turnOff(id)/turnOn(id)): ");
                        String action = sc.nextLine();
                        proxyHub.addTrigger(condition, action);
                        logger.info("Trigger {" + condition + ", " + action + "} added successfully");
                        break;
                    case "8":
                        proxyHub.showStatus();
                        break;
                    case "9":
                        proxyHub.showSchedules();
                        break;
                    case "10":
                        proxyHub.showTriggers();
                        break;
                    case "11":
                        System.out.println("Exiting...");
                        sc.close();
                        running.set(false);
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                logger.warning(e.getMessage());
            }
        }
        logger.info("Smart Home Application stopped....");
    }
}
