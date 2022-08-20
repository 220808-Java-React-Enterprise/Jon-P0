package com.revature.Cthulazon.ui;

import com.revature.Cthulazon.models.Store;
import com.revature.Cthulazon.models.User;
import com.revature.Cthulazon.services.UserService;
import com.revature.Cthulazon.services.StoreService;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidStoreException;


import java.util.Scanner;

public class AdminMenu implements IMenu {
    private final User user;
    private final UserService userService;
    private final StoreService storeService;
    public AdminMenu(User user, UserService userService, StoreService storeService) {
        this.user = user;
        this.userService = userService;
        this.storeService=storeService;
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
                System.out.println("[2] Add Inventory");
                System.out.println("[3] Exit!");
                adminInput = scan.nextLine();

                switch (adminInput) {
                    case "1":
                        storeService.getAllLocations();
                        System.out.println("needs to be implemented");
                        break;
                    case "2":
                        System.out.println("Selected to add Inventory");
                        addInventory();
                        break;
                    case "3":
                        break adminExit;
                    default:
                        break;
                }

            }
        }


    }


    private void addInventory() {
        String location="";
        int increaseTheInventory;
        Scanner scan = new Scanner(System.in);
        System.out.println("Which Store number do you want to add to?");

        while(true) {
             location = scan.nextLine();
            try {
                Store store = storeService.isValidStore(location);
                System.out.println("You are now accessing Store:" +store.getLocation());
            } catch (InvalidStoreException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("How much do you want to add?");


            int increaseNum = scan.nextInt();
break;
        }
    }


}

