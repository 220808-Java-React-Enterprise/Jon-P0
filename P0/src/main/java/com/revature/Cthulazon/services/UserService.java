package com.revature.Cthulazon.services;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidUserException;
import com.revature.Cthulazon.dao.UserDAO;
import com.revature.Cthulazon.models.User;
public class UserService {
    private final UserDAO userDAO;
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void register(User user) {
        userDAO.save(user);
    }

    public User login(String username, String password) {
        User user = userDAO.getUserByUsernameAndPassword(username, password);
        if (user == null) throw new InvalidUserException("\nIncorrect username or password :(");
        return user;
    }

    public boolean isValidUsername(String username) {

        if (!username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$"))
            throw new InvalidUserException("\"\\nInvalid username! username is 8-20 characters long. no _ or . at the beginning. no __ or _. or ._ or .. inside\"");
    return true;
    }


    public boolean isValidPassword(String password) {
        if (!password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$"))
            throw new InvalidUserException("\nInvalid password! Minimum eight characters, at least one letter and one number");
        return true;
    }

    public void isValidEmail(String emailAddress) {
        if (!emailAddress.matches("[A-Za-z0-9][A-Za-z0-9!#$%&'*+\\-/=?^_`{}|]{0,63}@[A-Za-z0-9.-]{1,253}.[A-Za-z]{2,24}"))
            throw new InvalidUserException("\nInvalid email, only A-Z,a-z,0-9 is allowed");
    }

    public void isValidFirstName(String firstName) {
        if (!firstName.matches("^[A-Z][a-zA-Z]+$")) throw new InvalidUserException("\nInvalid First Name");

    }

    public void isValidLastName(String lastName) {
        if (!lastName.matches("^[A-Z][a-zA-Z]+$")) throw new InvalidUserException("\nInvalid Last Name");

    }
    public void isDuplicateUsername(String userName)
    {
        if(userDAO.getUsername(userName)!=null)
            throw new InvalidUserException(("userName already taken"));

    }

    public String getName(String name)
    {
        return userDAO.getUsername(name);
    }

}