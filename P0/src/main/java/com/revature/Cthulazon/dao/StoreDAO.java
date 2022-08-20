package com.revature.Cthulazon.dao;

import com.revature.Cthulazon.models.Store;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidSQLException;
import com.revature.Cthulazon.utils.database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class StoreDAO implements InterfaceDAO<Store>{
    @Override
    public void save(Store obj) {

    }

    @Override
    public void update(Store obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Store getById(String id) {
        return null;
    }

    @Override
    public List<Store> getAll() {
        List<Store> locations = new ArrayList<>();

        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM stores");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Store store = new Store(rs.getString("storeID"), rs.getString("location"));
                locations.add(store);
            }
        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save to the database.");
        }

        return locations;
    }

    public Store isValidStoreDAO(String location) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM stores WHERE location= ?");
            ps.setString(1, location);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Store(rs.getString("storeID"), rs.getString("location"), rs.getString("soulInventory"));
            }

        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when accessing  the database.");
        }
        return null;
    }
}

