package com.revature.Cthulazon.ui;

import com.revature.Cthulazon.models.Product;
import com.revature.Cthulazon.models.Store;
import com.revature.Cthulazon.models.User;
<<<<<<< HEAD
import com.revature.Cthulazon.services.ProductService;
=======
<<<<<<< Updated upstream
=======
import com.revature.Cthulazon.models.Orders;
import com.revature.Cthulazon.services.OrderService;
import com.revature.Cthulazon.services.ProductService;
>>>>>>> Stashed changes
>>>>>>> test-branch
import com.revature.Cthulazon.services.UserService;
import com.revature.Cthulazon.services.StoreService;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidSQLException;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidStoreException;


import java.util.*;

public class AdminMenu implements IMenu {
    private final User user;
    private final UserService userService;
    private final StoreService storeService;
<<<<<<< HEAD
private final ProductService productService;
    public AdminMenu(User user, UserService userService, StoreService storeService,ProductService productService) {
        this.user = user;
        this.userService = userService;
        this.storeService = storeService;
        this.productService=productService;
=======
<<<<<<< Updated upstream

    public AdminMenu(User user, UserService userService, StoreService storeService) {
        this.user = user;
        this.userService = userService;
        this.storeService = storeService;
=======
    private final ProductService productService;
    private final OrderService orderService;


    public AdminMenu(User user, UserService userService, StoreService storeService, ProductService productService,OrderService orderService) {
        this.user = user;
        this.userService = userService;
        this.storeService = storeService;
        this.productService = productService;
        this.orderService=orderService;
>>>>>>> Stashed changes
>>>>>>> test-branch
    }

    //TODO
    @Override
    public void start() {
        System.out.println("\nWelcome to the admin menu " + user.getUserName() + "!");

        String adminInput = "";
        Scanner scan = new Scanner(System.in);


        adminExit:
        {
            while (true) {
                System.out.println("Choose from 1 to 5");
                System.out.println("[1] View Stores");
                System.out.println("[2] Add Stores");
                System.out.println("[3] Add Inventory");
                System.out.println("[4] Find a User");
                System.out.println("[5] View Store Orders");
                System.out.println("[6] Go Back");
                adminInput = scan.nextLine();

                switch (adminInput) {
                    case "1":
                        System.out.println("viewing Stores");
                        viewLocations();
                        ;
                        break;
                    case "2":
                        addStore();
                        break;
                    case "3":
                        System.out.println("Selected to add Inventory");
                        addInventory();
                        break;
                    case "4":
                        findUser();
                        break;
                    case"5":
                        viewOrderByLocation();
                        break;
                    case "6":
                        break adminExit;
                    default:
                        break;
                }

            }
        }


    }


    private void viewLocations() {
        List<Store> activeStores = storeService.getAllLocations();
        for (Store s : activeStores)
            System.out.println(s.getStoreID() + ": " + s.getCity() + ": " + s.getSoulInventory());
    }

    private void addStore() {
<<<<<<< HEAD
        String city;
        String storeNum = "";
=======
<<<<<<< Updated upstream
        String storeID = "store";
=======
        String city;
        String storeNum;
>>>>>>> Stashed changes
>>>>>>> test-branch
        int num = 0;
        int soulInventory = 0;


        Scanner scan = new Scanner(System.in);
        Scanner next = new Scanner(System.in);
        System.out.println("Creating Store...");

        storeCreationExit:
        {
            while (true) {

                storeNumberExit:
                {
                    while (true) {
                        {

                            System.out.println("Enter a number that is not taken between 0 to 999:");
                            num = scan.nextInt();
                            storeNum = "store" + String.valueOf(num);

                            try {
                                storeService.isStoreTaken(storeNum);
                                break storeNumberExit;
                            } catch (InvalidSQLException e) {
                                System.out.println(e.getMessage());

                            }
                        }

                    }
                }
<<<<<<< HEAD
=======
<<<<<<< Updated upstream
=======
>>>>>>> test-branch
                cityChosenExit:
                {
                    while (true) {
                        {

                            System.out.println("Enter a City from the list, no spaces are allowed (jacksonville, newyork, dallas)");
                            city = next.nextLine();

                            try {
                                storeService.isValidCity(city);
                                break cityChosenExit;
                            } catch (InvalidStoreException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }

                System.out.println("Creating Store....");

                Store store = new Store(UUID.randomUUID().toString(), storeNum, city, soulInventory);
                storeService.register(store);
                break;


            }
        }

    }

<<<<<<< HEAD
    private void addInventory() {
=======
    private void addInventory() throws IndexOutOfBoundsException {
>>>>>>> test-branch
        int increaseTheInventory;
        Scanner scan = new Scanner(System.in);
        adminBreak:
        {

            List<Store> store = storeService.getAllLocations();
            for (int i = 0; i < store.size(); i++) {
                System.out.println(" [" + i + "] " + store.get(i).toString());
<<<<<<< HEAD
            }
            int iWant;

            System.out.println("What store do you want to access?");
            iWant = scan.nextInt();
            Store storefront=store.get(iWant);

            System.out.println("By How Much:");
            int increaseNum = scan.nextInt();
            addProduct(increaseNum,storefront);
        }

    }

    private void addProduct(int number, Store store) {
        char[] ch={'A','B','C','D','F'};
        Random rand=new Random();
        String sanityGrade = null;
        int costToBuy=0;
       switch(rand.nextInt(4)+1) {

           case 1 :
               sanityGrade = "A";
               costToBuy=1000;
               break;
           case 2:
               sanityGrade = "B";
               costToBuy=750;
               break;
           case 3:
               sanityGrade = "C";
               costToBuy=500;
               break;
           case 4:
               sanityGrade = "D'";
               costToBuy=100;
               break;
           case 5:
               sanityGrade = "F";
               costToBuy=50;
               break;
           default:
               System.out.println("please enter a number 1 to 5");
               break;
       }

    for(int i=0;i<number;i++)
    {
        Product product = new Product(UUID.randomUUID().toString(),sanityGrade,costToBuy,true,store.getStoreID());
        productService.register(product);
    }

}


}
=======
>>>>>>> Stashed changes
            }

<<<<<<< Updated upstream
=======
            System.out.println("What store do you want to access?");
            iWant = scan.nextInt();
            Store storefront = store.get(iWant);

            System.out.println("By How Much:");
            int increaseNum = scan.nextInt();
            addProduct(increaseNum, storefront);
>>>>>>> Stashed changes
        }
    }

<<<<<<< Updated upstream
=======
    private void addProduct(int number, Store store) {
        char[] ch = {'A', 'B', 'C', 'D', 'F'};
        Random rand = new Random();
        String sanityGrade = null;
        int costToBuy = 0;
        for(int j=0;j<number;j++) {
            switch (rand.nextInt(4) + 1) {

                case 1:
                    sanityGrade = "A";
                    costToBuy = 1000;
                    break;
                case 2:
                    sanityGrade = "B";
                    costToBuy = 750;
                    break;
                case 3:
                    sanityGrade = "C";
                    costToBuy = 500;
                    break;
                case 4:
                    sanityGrade = "D'";
                    costToBuy = 100;
                    break;
                case 5:
                    sanityGrade = "F";
                    costToBuy = 50;
                    break;
                default:
                    System.out.println("please enter a number 1 to 5");
                    break;
            }

            for (int i = 0; i < 1; i++) {
                Product product = new Product(UUID.randomUUID().toString(), sanityGrade, costToBuy, true, store.getStoreID());
                productService.register(product);
            }
        }
        storeService.updateStoreInventory(store.getStoreID(), number);


    }

    public void findUser() {
        System.out.println("Type in a valid Username");
        Scanner scan = new Scanner(System.in);
        String name=scan.nextLine();

        if(userService.getName(name)!=null) {
            System.out.println("Found! " + userService.getName(name));
        }
        else
            System.out.println("Not Found!");


    }

   private void viewOrderByLocation()
    {
        Scanner scan=new Scanner(System.in);
        List<Store> store = storeService.getAllLocations();
        for (int i = 0; i < store.size(); i++) {
            System.out.println(" [" + i + "] " + store.get(i).toString());
        }
        int iWant;

        System.out.println("What store do you want to access?");
        iWant = scan.nextInt();
        Store storefront = store.get(iWant);

        List<Orders> order = orderService.getHistoryOfStore(storefront.getStoreID());
        for (int i = 0; i < order.size(); i++) {
            System.out.println(" [" + i + "] " + order.get(i).toString());
        }

    }
}
>>>>>>> Stashed changes
>>>>>>> test-branch
