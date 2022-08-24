package com.revature.Cthulazon.dao;

import com.revature.Cthulazon.models.Orders;
import com.revature.Cthulazon.models.Store;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidSQLException;
import com.revature.Cthulazon.utils.database.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements InterfaceDAO<Orders> {

        @Override
        public void save(Orders obj) {
            try (Connection con = ConnectionFactory.getInstance().getConnection()) {
<<<<<<< HEAD
                PreparedStatement ps = con.prepareStatement("INSERT INTO orders(orderID,userID,storeID,date,total) values (?, ?,? ,?,?)");
                ps.setString(1, obj.getOrderID());
                ps.setString(2, obj.getUserID());
                ps.setString(3,obj.getStoreID());
                ps.setString(4, obj.getDate());
                ps.setInt(5,  obj.getAmount());
=======
<<<<<<< Updated upstream
                PreparedStatement ps = con.prepareStatement("INSERT INTO orders(userID,storeID,date,total) values (?, ? ,?,?)");
                ps.setString(1, obj.getOrderID());
                ps.setString(2, obj.getUserID());
                ps.setString(3, obj.getDate());
                ps.setInt(4, (int) obj.getAmount());
=======
                PreparedStatement ps = con.prepareStatement("INSERT INTO orders(orderID,userID,storeID,date,total) values (?, ?,?,?,?)");
                ps.setString(1, obj.getOrderID());
                ps.setString(2, obj.getUserID());
                ps.setString(3, obj.getStoreID());
                ps.setDate(4, (Date) obj.getDate());
                ps.setInt(5,  obj.getAmount());
>>>>>>> Stashed changes
>>>>>>> test-branch

                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new InvalidSQLException("An error occurred when trying to save Cart to the database.");
            }
        }

        public void update(Orders obj) {

        }

        @Override
        public void delete(String id) {

        }


        @Override
        public Orders getById(String orderID) {
            try (Connection con = ConnectionFactory.getInstance().getConnection()) {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM carts WHERE orderID = ?");
                ps.setString(1, orderID);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
<<<<<<< HEAD
                    return new Orders(rs.getString("OrderID"), rs.getString("userID"),rs.getString("storeID"),rs.getString("Date"),rs.getInt("Amount"));
=======
<<<<<<< Updated upstream
                    return new Orders(rs.getString("OrderID"), rs.getString("cartID"), rs.getString("userID"),rs.getString("storeID"),rs.getString("Date"),rs.getInt("Amount"));
=======
                    return new Orders(rs.getString("OrderID"), rs.getString("userID"),rs.getString("storeID"),rs.getDate("Date"),rs.getInt("Amount"));
>>>>>>> Stashed changes
>>>>>>> test-branch
                }

            } catch (SQLException e) {
                throw new InvalidSQLException("An error occurred when trying to access User Cart from the database.");
            }

            return null;
        }

        @Override
        public List<Orders> getAll () {
                List<Orders> orders = new ArrayList<>();

                try (Connection con = ConnectionFactory.getInstance().getConnection()) {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM orders");
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        Orders order = new Orders(rs.getString("orderID"),rs.getString("userID"),rs.getString("storeID"),rs.getDate("date"),rs.getInt("total"));
                        orders.add(order);
                    }
                } catch (SQLException e) {
                    throw new InvalidSQLException("An error occurred when trying to save to the database.");
                }

                return orders;
        }


    public List<Orders> getByStore (String storeID) {
        List<Orders> orders = new ArrayList<>();

        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM orders Where storeid=?");
            ps.setString(1,storeID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Orders order = new Orders(rs.getString("orderID"),rs.getString("userID"),rs.getString("storeID"),rs.getDate("date"),rs.getInt("total"));
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save to the database.");
        }

        return orders;
    }
    }


