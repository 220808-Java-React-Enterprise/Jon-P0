package com.revature.Cthulazon.dao;

import com.revature.Cthulazon.models.User;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidSQLException;
import com.revature.Cthulazon.utils.database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO implements InterfaceDAO<User> {
    //Insert to db and save
    @Override
    public void save(User obj) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO users (userid,username,password,ROLE,emailaddress,firstname,lastname) values (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, obj.getUserID());
            ps.setString(2, obj.getUserName());
            ps.setString(3, obj.getPassword());
            ps.setString(4, obj.getRole());
            ps.setString(5, obj.getEmailAddress());
            ps.setString(6, obj.getFirstName());
            ps.setString(7, obj.getLastName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save to the database.");
        }
    }

    @Override
    public void update(User obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public User getById(String userID) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE userID = ?");
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(rs.getString("userID"), rs.getString("userName"), rs.getString("password"), rs.getString("role"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("emailAddress"));
            }

        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when tyring to save to the database.");
        }

        return null;
    }

    public String getUsername(String username) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT (username) FROM users WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) return rs.getString("username");

        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when tyring to save to the database.");
        }

        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return new User(rs.getString("userID"), rs.getString("userName"), rs.getString("password"), rs.getString("role"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("emailAddress"));
        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when tyring to save to the database.");
        }

        return null;
    }
}


