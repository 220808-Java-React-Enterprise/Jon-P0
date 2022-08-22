package com.revature.Cthulazon.ui;

import com.revature.Cthulazon.models.Store;
import com.revature.Cthulazon.models.User;
import com.revature.Cthulazon.services.UserService;
import com.revature.Cthulazon.services.StoreService;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidStoreException;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidUserException;


import java.util.List;
import java.util.Scanner;

public class AdminMenu implements IMenu {
    private final User user;
    private final UserService userService;
    private final StoreService storeService;

    public AdminMenu(User user, UserService userService, StoreService storeService) {
        this.user = user;
        this.userService = userService;
        this.storeService = storeService;
    }

    @Override
    public void start() {
        System.out.println("\nWelcome to the admin menu " + user.getUserName() + "!");

        String adminInput = "";
        Scanner scan = new Scanner(System.in);


        adminExit:
        {
            while (true) {
                System.out.println("Choose from 1 to 3");
                System.out.println("[1] View Stores");
                System.out.println("[2] Add Stores");
                System.out.println("[3] Add Inventory");
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
                    case "4":
                        break adminExit;
                    default:
                        break;
                }

            }
        }


    }


    private void addInventory() {
        String location = "";
        int increaseTheInventory;
        Scanner scan = new Scanner(System.in);
        System.out.println("Which Store number do you want to add to?");
        adminBreak:
        {
            while (true) {
                location = scan.nextLine();
                try {
                    Store store = storeService.isValidStore(location);
                    System.out.println("You are now accessing Store:" + store.getLocation());
                } catch (InvalidStoreException e) {
                    System.out.println(e.getMessage());
                    break adminBreak;
                }
                System.out.println("By How Much:");
                int increaseNum = scan.nextInt();
            }

        }
    }

    private void viewLocations() {
        List<Store> activeStores = storeService.getAllLocations();
        for (Store s : activeStores)
            System.out.println(s.getStoreID() + ": " + s.getLocation() + ": " + s.getSoulInventory());
    }

    private void addStore() {
        String storeID = "store";
        int num = 0;
        String location = "";
        int soulInventory = 0;


        Scanner scan = new Scanner(System.in);

        System.out.println("Creating Store...");

        storeCreationExit:
        {
            while (true) {


                        System.out.println("listing Stores...");
                        viewLocations();
                        System.out.println("Enter a number that is not taken between 0 to 999:");
                        num = scan.nextInt();
                        storeID = storeID + String.valueOf(num);



                }
            }

        }
    }

