package com.revature.Cthulazon.ui;
import com.revature.Cthulazon.models.Cart;
import com.revature.Cthulazon.models.Store;
import com.revature.Cthulazon.models.User;
import com.revature.Cthulazon.services.CartService;
import com.revature.Cthulazon.services.UserService;
import com.revature.Cthulazon.services.StoreService;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
public class MainMenu implements IMenu {
    private final User user;
    private final UserService userService;
    private final StoreService storeService;
    private final CartService cartService;
    public MainMenu(User user, UserService userService,StoreService storeService,CartService cartService) {
        this.user = user;
        this.userService = userService;
        this.storeService=storeService;
        this.cartService=cartService;

    }

    @Override
    public void start() {
        Scanner scan = new Scanner(System.in);

        exit:
        {
            while (true) {
                System.out.println("\nWelcome to the main menu " + user.getUserName() + "!");
                System.out.println("[1] View all locations");
                System.out.println("[2] View Cart!");
                System.out.println("[3] Sign out!");
                System.out.print("\nEnter: ");

                switch (scan.nextLine()) {
                    case "1":
                        viewLocations();
                        break;
                    case "2":
                        System.out.println("Printing Your Cart...");
                        System.out.println("items currently in your cart");
                        System.out.println("-------------------------------------------------------------------------------");
                        viewCart();
                    case "3":
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

    private void viewCart(){
        Cart userCart= cartService.getById(user.getUserID());
        System.out.println(userCart.toString());
    }
}