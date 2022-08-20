package com.revature.Cthulazon.ui;

import com.revature.Cthulazon.models.User;
import com.revature.Cthulazon.models.Store;
import com.revature.Cthulazon.services.UserService;
import com.revature.Cthulazon.services.StoreService;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidStoreException;


import java.util.Scanner;

public class AdminMenu implements IMenu {
    private final User user;
    private final UserService userService;

    public AdminMenu(User user, UserService userService) {
        this.user = user;
        this.userService = userService;
    }


    public void start() {
        System.out.println("\nWelcome to the admin menu " + user.getUserName() + "!");

        String adminInput = "";
        Scanner scan = new Scanner(System.in);


        adminExit:
        {
            while (true) {
                System.out.println("Choose from 1 to 3");
                System.out.println("[1] View Store");
                System.out.println("[2] Add Inventory");
                System.out.println("[3] Exit!");
                adminInput = scan.nextLine();

                switch (adminInput) {
                    case "1":
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
        Scanner scan = new Scanner(System.in);
        System.out.println("Which Store number do you want to add to?");
        String location = scan.nextLine();
       try {
            Store store = StoreService.isValidStore(location);
        } catch (InvalidStoreException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("How much do you want to add?");

        int increaseNum = scan.nextInt();


    }
}

