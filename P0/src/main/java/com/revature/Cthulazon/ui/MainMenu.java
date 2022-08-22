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
    private Store currentstore=new Store("storeId1","Jacksonville","1");
    private final UserService userService;
    private final StoreService storeService;
    private final CartService cartService;
    private final OrderService orderService;
    private final ProductService productService;
    public MainMenu(User user, Cart cart, UserService userService, StoreService storeService, CartService cartService, OrderService orderService,ProductService productService) {
        this.user = user;
        this.userCart=cart;
        this.userService = userService;
        this.storeService=storeService;
        this.cartService=cartService;
        this.orderService=orderService;
        this.productService=productService;

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
                System.out.println("[5] AddProduct! ");
                System.out.println("[6] Exit");
                System.out.print("\nEnter: ");

                switch (scan.nextLine()) {
                    case "1":
                        viewLocations();
                        break;
                    case "2":
                        chooseStore();
                        System.out.println("You are now viewing");
                        System.out.println(currentstore.getStoreID() +" " + currentstore.getCity());
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
                        String date= String.valueOf(dateNow);
                        Orders order = new Orders(UUID.randomUUID().toString(), userCart.getCartID(), user.getUserID(), currentstore.getStoreID(), date, 1);
                        System.out.println(order);
                        System.out.println("You now own:" +userCart.getSoulID());

                        break exit;
                    case "5":
                        addProduct();
                        break exit;
                    case "6":
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

        System.out.print("\nSelect a location: ");
        String storeId = scan.nextLine();
        this.currentstore = storeService.getById(storeId);

    }
    private void viewCart(){
        Cart userCart= cartService.getById(user.getUserID());
        System.out.println(userCart.toString());
    }

   private void addProduct(){
        storeService.getAllStoreProducts(currentstore.getStoreID());
    Scanner scan=new Scanner(System.in);
    String iWant;

            System.out.println("enter an productID!");
                    iWant=scan.nextLine();

        userCart.setSoulID(iWant);
        productService.availUpdate(iWant);


    }

}

