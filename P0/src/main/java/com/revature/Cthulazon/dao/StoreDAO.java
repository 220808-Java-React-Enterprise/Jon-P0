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

<<<<<<< HEAD
<<<<<<< Updated upstream
        @Override
        public void delete (String id){
=======
    public void updateInput(String obj,int count) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("Update stores set soulInventory=soulInventory+"+count+" where storeID=?");
            ps.setString(1, obj);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save to the database.");
        }
    }

>>>>>>> Stashed changes
=======
>>>>>>> bfab96b7f3f01318e73c4eac7b9abff3915cd093

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

<<<<<<< HEAD
<<<<<<< Updated upstream
                while (rs.next()) {
                    Store store = new Store(rs.getString("storeID"), rs.getString("city"));
                    locations.add(store);
                }
            } catch (SQLException e) {
                throw new InvalidSQLException("An error occurred when trying to save to the database.");
=======
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM stores");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Store store = new Store(rs.getString("storeID"),rs.getString("storeNumber"),rs.getString("city"),rs.getInt("soulInventory"));
                locations.add(store);
>>>>>>> Stashed changes
            }
=======
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM stores");
            ResultSet rs = ps.executeQuery();
>>>>>>> bfab96b7f3f01318e73c4eac7b9abff3915cd093

            while (rs.next()) {
                Store store = new Store(rs.getString("storeID"), rs.getString("city"));
                locations.add(store);
            }
        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save to the database.");
        }

        return locations;
    }

    public String getStoreNumber(String storenum) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT (storenumber) FROM stores WHERE storenumber = ?");
            ps.setString(1,storenum);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) return rs.getString("storenumber");

        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save to the database.");
        }
        
        return null;
    }
}

