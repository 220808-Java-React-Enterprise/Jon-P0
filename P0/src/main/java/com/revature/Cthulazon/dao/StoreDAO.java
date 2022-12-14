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

public class StoreDAO implements InterfaceDAO<Store> {
    @Override
    public void save(Store obj) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO stores (storeid,storenumber,city,soulinventory) values (?,?,?, ?)");
            ps.setString(1, obj.getStoreID());
            ps.setString(2, obj.getStoreNumber());
            ps.setString(3, obj.getCity());
            ps.setInt(4, obj.getSoulInventory());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save to the database.");
        }
    }

    @Override
    public void update(Store obj) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("Update stores set soulInventory=soulInventory+1 where storeID=?");
            ps.setString(1, obj.getStoreID());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save to the database.");
        }
    }

    @Override
    public void delete(String id) {

    }

    

    @Override
    public Store getById(String id) {
        return null;
    }

    public List<Store> getAll() {
        List<Store> locations = new ArrayList<>();
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM stores");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Store store = new Store(rs.getString("storeID"),rs.getString("storenumber") ,rs.getString("city"),rs.getInt("soulInventory"));
                locations.add(store);
            }
            return locations;
        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save to the database.");
        }
    }

        public Store isStoreTakenDAO(String storeID){
            try (Connection con = ConnectionFactory.getInstance().getConnection()) {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM stores WHERE storeId= ?");
                ps.setString(1, storeID);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return new Store(rs.getString("storeID"));
                }
            } catch (SQLException e) {
                throw new InvalidSQLException("An error occurred when accessing  the database.");
            }
            return null;
        }


        public String getStoreNumber (String storenum){
            try (Connection con = ConnectionFactory.getInstance().getConnection()) {
                PreparedStatement ps = con.prepareStatement("SELECT (storenumber) FROM stores WHERE storenumber = ?");
                ps.setString(1, storenum);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) return rs.getString("storenumber");

            } catch (SQLException e) {
                throw new InvalidSQLException("An error occurred when trying to save to the database.");
            }

            return null;
        }

    public void updateInput(String store, int count) {
            try (Connection con = ConnectionFactory.getInstance().getConnection()) {
                PreparedStatement ps = con.prepareStatement("Update stores set soulInventory=soulInventory+"+count+" where storeID=?");
                ps.setString(1, store);
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new InvalidSQLException("An error occurred when trying to save to the database.");
            }
        }
    }


