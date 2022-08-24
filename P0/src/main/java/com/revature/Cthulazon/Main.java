package com.revature.Cthulazon;
import com.revature.Cthulazon.dao.UserDAO;
import com.revature.Cthulazon.dao.CartDAO;
import com.revature.Cthulazon.services.CartService;
import com.revature.Cthulazon.services.UserService;
import com.revature.Cthulazon.ui.LoginMenu;
import com.revature.Cthulazon.utils.database.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {


        new LoginMenu(new UserService(new UserDAO()),new CartService(new CartDAO())).start();

        try{
            System.out.println(ConnectionFactory.getInstance().getConnection());
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
