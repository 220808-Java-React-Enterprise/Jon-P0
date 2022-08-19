package com.revature.Cthulazon.ui;
import com.revature.Cthulazon.models.Store;
import com.revature.Cthulazon.models.User;
import com.revature.Cthulazon.services.UserService;
import com.revature.Cthulazon.services.StoreService;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
public class MainMenu implements IMenu {
    private final User user;
    private final UserService userService;
    private final StoreService storeService;
    public MainMenu(User user, UserService userService,StoreService storeService) {
        this.user = user;
        this.userService = userService;
        this.storeService=storeService;

    }

    @Override
    public void start() {
        Scanner scan = new Scanner(System.in);

        exit:
        {
            while (true) {
                System.out.println("\nWelcome to the main menu " + user.getUserName() + "!");
                System.out.println("[1] View all locations");
                System.out.println("[x] Sign out!");
                System.out.print("\nEnter: ");

                switch (scan.nextLine()) {
                    case "1":
                        viewLocations();
                        break;
                    case "2":
                        break exit;
                    default:
                        System.out.println("\nInvalid input!");
                        break;
                }
            }
        }
    }

    private void viewLocations() {
        Scanner scan = new Scanner(System.in);

        exit:
        {
            while (true) {
                System.out.println("\nViewing all locations...");
                List<Store> locations = storeService.getAllLocations();
                for (int i = 0; i < locations.size(); i++) {
                    System.out.println("[" + (i + 1) + "] " + locations.get(i).getLocation());
                }

                System.out.print("\nSelect a location: ");
                int index = scan.nextInt() - 1;


            }
        }
    }
}