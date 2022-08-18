package com.revature.Cthulazon;
import com.revature.Cthulazon.ui.LoginMenu;
import com.revature.Cthulazon.utils.database.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {


        //ew LoginMenu().start();

        try{
            System.out.println(ConnectionFactory.getInstance().getConnection());
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
