package com.revature.Cthulazon.ui;
import com.revature.Cthulazon.models.*;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidUserException;
import com.revature.Cthulazon.dao.StoreDAO;
import com.revature.Cthulazon.dao.UserDAO;
import com.revature.Cthulazon.services.UserService;
import com.revature.Cthulazon.services.StoreService;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;
public class LoginMenu implements IMenu {
    String userInput = "";
    private final UserService userService;

    public LoginMenu(UserService userService) {
        this.userService = userService;
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        exit:
        {
            while (true) {
                System.out.println("Welcome to Cthuluzon");
                System.out.println("[1] Login");
                System.out.println("[2] Signup");
                System.out.println("[3] Exit!");
                userInput = scan.nextLine();

                switch (userInput) {
                    case "1":
                        login();
                        break;
                    case "2":
                        User user = signup();
                        userService.register(user);
                        break;
                    case "3":
                        System.out.println("Goodbye!");
                        break exit;
                    default:
                        System.out.println("please enter a number 1 to 3");
                        break;
                }
            }

        }
    }

    private void login() {
        String username = "";
        String password = "";
        Scanner scan = new Scanner(System.in);

        System.out.println("\nLogging in...");
        exit:
        {
            while (true) {
                System.out.print("\nEnter username: ");
                username = scan.nextLine();

                System.out.print("\nEnter password: ");
                password = scan.nextLine();
                    try{
                        User user = userService.login(username, password);
                        if (user.getRole().equals("ADMIN")) new AdminMenu(user, new UserService(new UserDAO())).start();
                        else new MainMenu(user, new UserService(new UserDAO()), new StoreService(new StoreDAO())).start();
                        break exit;
                    }catch(InvalidUserException e){
                    System.out.println(e.getMessage());

                }
            }
        }
    }
    private User signup() {
        String username = "";
        String password = "";
        String lastName = "";
        String firstName = "";
        String emailAddress = "";
        User user = null;

        Scanner scan = new Scanner(System.in);

        System.out.println("Creating account...");

        exit:
        {
            while (true) {

                //USERNAME INPUT
                usernameExit:
                while (true) {
                    {
                        System.out.println("Enter a username:");
                        username = scan.nextLine();
                        try {
                            userService.isValidUsername(username);

                           userService.isDuplicateUsername(username);
                            break usernameExit;
                        } catch (InvalidUserException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                }
                passwordExit:
                {
                    //PASSWORD INPUT
                    while (true) {
                        System.out.println("Enter a password: ");
                        password = scan.nextLine();
                        try {
                            userService.isValidPassword(password);
                            break passwordExit;
                        } catch (InvalidUserException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                emailAddressExit:
                {

                    while (true) {
                        {
                            System.out.println("Enter your email address:");
                            emailAddress = scan.nextLine();
                            try {
                                userService.isValidEmail(emailAddress);
                                break emailAddressExit;
                            } catch (InvalidUserException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                    }
                }


                firstNameExit:
                {

                    while (true) {
                        {
                            System.out.println("Enter your first name:");
                            firstName = scan.nextLine();
                            try {
                                userService.isValidFirstName(firstName);
                                break firstNameExit;
                            } catch (InvalidUserException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                    }
                }

                lastNameExit:
                {

                    while (true) {
                        {
                            System.out.println("Enter your last name:");
                            lastName = scan.nextLine();
                            try {
                                userService.isValidLastName(lastName);
                                break lastNameExit;
                            } catch (InvalidUserException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                    }
                }
                confirmExit:
                {
                    while (true) {
                        System.out.println("\nIs this correct (y/n):");
                        System.out.println("Username: " + username + "\nPassword: " + password + "\nEmail Address " + emailAddress + "\nFirst Name " +firstName + "\nLast Name " +lastName);
                        System.out.print("\nEnter: ");

                        switch (scan.nextLine().toLowerCase()) {
                            case "y":
                                user = new User(UUID.randomUUID().toString(), username, password,emailAddress,firstName,lastName);
                                return user;
                            case "n":
                                System.out.println("\nRestarting...");
                                break confirmExit;
                            default:
                                System.out.println("\nInvalid input!");
                                break;
                        }
                        break exit;
                    }
                }
            }
        }
        return user;
    }
}