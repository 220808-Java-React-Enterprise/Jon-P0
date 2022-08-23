package com.revature.Cthulazon.ui;

import com.revature.Cthulazon.models.Cart;
import com.revature.Cthulazon.models.Store;
import com.revature.Cthulazon.models.User;
import com.revature.Cthulazon.models.Orders;
import com.revature.Cthulazon.models.Product;
import com.revature.Cthulazon.services.CartService;
import com.revature.Cthulazon.services.UserService;
import com.revature.Cthulazon.services.StoreService;
import com.revature.Cthulazon.services.OrderService;
import com.revature.Cthulazon.services.ProductService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class MainMenu implements IMenu {
    private final User user;
    private final Cart userCart;
    private Store currentstore;
    private final UserService userService;
    private final StoreService storeService;
    private final CartService cartService;
    private final OrderService orderService;
    private final ProductService productService;


    public MainMenu(User user, Cart cart, UserService userService, StoreService storeService, CartService cartService, OrderService orderService, ProductService productService) {
        this.user = user;
        this.userCart = cart;
        this.userService = userService;
        this.storeService = storeService;
        this.cartService = cartService;
        this.orderService = orderService;
        this.productService = productService;

    }

    @Override
    public void start() {
        Scanner scan = new Scanner(System.in);

        exit:
        {
            while (true) {
                System.out.println("\nWelcome to the main menu " + user.getUserName() + "!");
                System.out.println("[1] View all locations!");
                System.out.println("[2] Select Store!");
                System.out.println("[3] View Cart!");
                System.out.println("[4] CheckOut!");
                System.out.println("[5] Exit! ");

                System.out.print("\nEnter: ");

                switch (scan.nextLine()) {
                    case "1":
                        viewLocations();
                        break;
                    case "2":
                        chooseStore();
                        System.out.println("You are now viewing");
                        System.out.println(currentstore.getStoreID() + " " + currentstore.getCity());
                        break;
                    case "3":
                        System.out.println("Printing Your Cart...");
                        System.out.println("items currently in your cart");
                        System.out.println("-------------------------------------------------------------------------------");
                        viewCart();
                        break;
                    case "4":
                        System.out.println("CHECKOUT");
                        System.out.println("-------------------------------------------------------------------------------");
                        addProduct();
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                        LocalDateTime dateNow = LocalDateTime.now();
                        String date = String.valueOf(dateNow);
                        Orders order = new Orders(UUID.randomUUID().toString(), user.getUserID(), currentstore.getStoreID(), date, 1);
                        orderService.saveOrder(order);
                        System.out.println(order.toString());
                        System.out.println("You now own:" + userCart.getSoulID());
                        break;
                    case "5":
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

        System.out.println("\nViewing all locations...");
        List<Store> locations = storeService.getAllLocations();
        for (int i = 0; i < locations.size(); i++) {
            System.out.println("[" + locations.get(i).getStoreID() + "] " + locations.get(i).getCity());
        }


    }


    private void chooseStore() {
        Scanner scan = new Scanner(System.in);
        List<Store> locations = storeService.getAllLocations();


        for (int i = 0; i < locations.size(); i++) {
            System.out.println(" [" + i +"] " + locations.get(i).toString());
        }

        System.out.print("\nSelect a location: ");
        int storeNum = scan.nextInt();
        this.currentstore=locations.get(storeNum);
this.currentstore.toString();



    }

    private void viewCart() {
        Cart userCart = cartService.getById(user.getUserID());
        System.out.println(userCart.toString());
    }

    private void addProduct() {

        productService.getAllAtStore(currentstore.getStoreID());
        System.out.println("\nViewing all products at store :"+ currentstore.getStoreID());
        List<Product> products = productService.getAllAtStore(currentstore.getStoreID());
        for (int i = 0; i < products.size(); i++) {
            System.out.println(" [" + i +"] " + products.get(i).toString());
        }

        Scanner scan = new Scanner(System.in);
      int iWant;

        System.out.println("What do you want to purchase?");
        iWant = scan.nextInt();

        this.userCart.setSoulID(products.get(iWant).getSoulID());
        productService.availUpdate(products.get(iWant).getSoulID());


    }

}

