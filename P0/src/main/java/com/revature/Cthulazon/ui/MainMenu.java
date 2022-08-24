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
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidStoreException;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidUserException;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidUserSelection;

import com.revature.Cthulazon.services.ProductService;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
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
                System.out.println("[4] AddProduct!");
                System.out.println("[5] CheckOut!");
                System.out.println("[6] View Order history");
                System.out.println("[7 Exit");
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
                        addProduct();
                        break;
                    case "5":
                        checkOut(userCart);
                        break;
                    case "6":
                        viewOrderHistory();
                        break;
                    case "7":
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

            System.out.println(" [" + i + "] " + locations.get(i).toString());

        }
        storeChooseExit:
        {
            {
                System.out.print("\nSelect a location: ");

                int storeNum = scan.nextInt();
                if (storeNum > locations.size() || storeNum < locations.size()) {
                    storeNum = 0;
                    System.out.println("Sorry Number was not understood, redirecting you to :" + locations.get(0).toString());
                }

                this.currentstore = locations.get(storeNum);
                System.out.print("\nSelect a location: ");
                this.currentstore = locations.get(storeNum);
                this.currentstore.toString();
            }
        }
    }


    private void viewCart() {
        Cart userCart = cartService.getById(user.getUserID());
        System.out.println(userCart.toString());

    }


    private void checkOut(Cart cart) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime dateNow = LocalDateTime.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(dateNow.toLocalDate());
        Product product = productService.getById((cart.getSoulID()));
        Orders order = new Orders(UUID.randomUUID().toString(), user.getUserID(), currentstore.getStoreID(), sqlDate, product.getCostToBuy());
        orderService.saveOrder(order);
        System.out.println(order.toString());
        System.out.println("You now own:" + "SoulID:" + userCart.getSoulID());
        productService.availUpdate(userCart.getSoulID());
        storeService.updateStoreInventory(currentstore.getStoreID(), -1);

    }

    private void addProduct() {

        productService.getAllAtStore(currentstore.getStoreID());
        System.out.println("\nViewing all products at store :" + currentstore.getStoreID());
        List<Product> products = productService.getAllAvaliable(currentstore.getStoreID());
        for (int i = 0; i < products.size(); i++) {
            System.out.println(" [" + i + "] " + products.get(i).toString());
        }

        Scanner scan = new Scanner(System.in);
        int iWant;

        System.out.println("What do you want to purchase?");
        try {
            iWant = scan.nextInt();

            this.userCart.setSoulID(products.get(iWant).getSoulID());
            productService.availUpdate(products.get(iWant).getSoulID());
            cartService.update(userCart);
        } catch (InvalidStoreException e) {
            System.out.println("sorry something went wrong");
        }
    }


    private void viewOrderHistory() {

        List<Orders> order = orderService.getHistory(user.getUserID());
            historyExit:
            {
                while (true) {
                    System.out.println("[1] sort by date!");
                    System.out.println("[2] sort by amount!");
                    System.out.println("[3] back to main!");

                    Scanner scan = new Scanner(System.in);
                    switch (scan.nextLine()) {
                        case "1":
                            order.sort(Comparator.comparing((Orders::getDate)));
                            break historyExit;
                        case "2":
                            order.sort(Comparator.comparing((Orders::getAmount)));
                            break historyExit;
                        case "3":
                            break historyExit;
                        default:
                            System.out.println("Invalid Input");
                            break historyExit;
                    }
                }
            }


            for (int i = 0; i < order.size(); i++) {
                System.out.println(" [" + i + "] " + order.get(i).toString());
            }



    }
}



