package com.revature.Cthulazon.dao;
import com.revature.Cthulazon.models.Cart;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidSQLException;
import com.revature.Cthulazon.utils.database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CartDAO implements InterfaceDAO<Cart> {
    public void firstTime(Cart obj) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO carts (cartID,userID,soulID) VALUES (?, ?,?)");
            ps.setString(1, obj.getCartID());
            ps.setString(2, obj.getUserID());
            ps.setString(3,obj.getSoulID());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new InvalidSQLException("An error occurred when trying to save Cart to the database.");
        }
    }
    @Override
    public void save(Cart obj) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO carts (cartID,userID,soulID) values (?, ? ,?)");
            ps.setString(1, obj.getCartID());
            ps.setString(2, obj.getUserID());
            ps.setString(3, obj.getSoulID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new InvalidSQLException("An error occurred when trying to save Cart to the database.");

        }
    }

    public void update(Cart obj) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("Update carts set soulID=? where cartid=?");
            ps.setString(1, obj.getSoulID());
            ps.setString(2, obj.getCartID());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new InvalidSQLException("An error occurred when trying to save Cart to the database.");

        }

    }

    @Override
    public void delete(String id) {

    }


    @Override
    public Cart getById(String cartD) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM carts WHERE userID = ?");
            ps.setString(1, cartD);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Cart(rs.getString("cartID"), rs.getString("userID"), rs.getString("soulID"));
            }

        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to access User Cart from the database.");
        }

        return null;
    }

    @Override
    public List<Cart> getAll () {
        return null;
    }
}
