package com.revature.Cthulazon.ui;

import java.util.Scanner;

import com.revature.Cthulazon.models.*;
import com.revature.Cthulazon.services.UserService;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidUserException;

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
        System.out.println("" + "implementation");
    }


    private User signup() {
        String username = "";
        String password = "";
        String lastName = "";
        String firstName = "";
        String emailAddress= "";
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

                break exit;
            }
        }
        return user;
    }
}
