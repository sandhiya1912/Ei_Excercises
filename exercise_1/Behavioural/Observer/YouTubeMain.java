package exercise_1.Behavioural.Observer;

import java.util.*;

import exercise_1.Behavioural.Observer.models.Content;
import exercise_1.Behavioural.Observer.observer.User;
import exercise_1.Behavioural.Observer.subject.Channel;

public class YouTubeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean start = true;

        Map<String, Channel> channels = new HashMap<>();

        Channel techChannel = new Channel("TechWorld");
        Channel foodChannel = new Channel("FunVlogs");

        channels.put(techChannel.getChannelName(), techChannel);
        channels.put(foodChannel.getChannelName(), foodChannel);

        techChannel.subscribe(new User("Sandhiya"));
        techChannel.subscribe(new User("Jasmine"));
        techChannel.subscribe(new User("Vijay"));

        foodChannel.subscribe(new User("kaviya"));
        foodChannel.subscribe(new User("shalini"));

        while (start) {
            System.out.println("\nAvailable Channels: " + channels.keySet());
            System.out.print("Enter channel name (or exit): ");
            String channelName = sc.nextLine();

            if (channelName.equalsIgnoreCase("exit")) break;

            Channel selected = channels.get(channelName);
            if (selected == null) {
                System.out.println("Invalid channel name!");
                continue;
            }

            System.out.println("\nOptions:");
            System.out.println("1. Upload video");
            System.out.println("2. Upload short");
            System.out.println("3. Upload photo");
            System.out.print("Choose: ");
            int choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter video title: ");
                        String vTitle = sc.nextLine();
                        selected.uploadContent(new Content("Video", vTitle));
                        break;
                    case 2:
                        System.out.print("Enter short title: ");
                        String sTitle = sc.nextLine();
                        selected.uploadContent(new Content("Short", sTitle));
                        break;
                    case 3:
                        System.out.print("Enter photo description: ");
                        String desc = sc.nextLine();
                        selected.uploadContent(new Content("Photo", desc));
                        break;
                    default:
                        System.out.println("Invalid choice, please select again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}
