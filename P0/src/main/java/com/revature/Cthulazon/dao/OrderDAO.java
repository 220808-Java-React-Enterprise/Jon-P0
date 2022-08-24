package com.revature.Cthulazon.dao;

import com.revature.Cthulazon.models.Orders;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidSQLException;
import com.revature.Cthulazon.utils.database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDAO implements InterfaceDAO<Orders> {

        @Override
        public void save(Orders obj) {
            try (Connection con = ConnectionFactory.getInstance().getConnection()) {
                PreparedStatement ps = con.prepareStatement("INSERT INTO orders(orderID,userID,storeID,date,total) values (?, ?,? ,?,?)");
                ps.setString(1, obj.getOrderID());
                ps.setString(2, obj.getUserID());
                ps.setString(3,obj.getStoreID());
                ps.setString(4, obj.getDate());
                ps.setInt(5,  obj.getAmount());

                ps.executeUpdate();
            } catch (SQLException e) {
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
                    return new Orders(rs.getString("OrderID"), rs.getString("userID"),rs.getString("storeID"),rs.getString("Date"),rs.getInt("Amount"));
                }

            } catch (SQLException e) {
                throw new InvalidSQLException("An error occurred when trying to access User Cart from the database.");
            }

            return null;
        }

        @Override
        public List<Orders> getAll () {
            return null;
        }
    }


