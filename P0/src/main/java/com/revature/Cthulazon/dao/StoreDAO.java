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
            PreparedStatement ps = con.prepareStatement("INSERT INTO stores (storeid,location,soulinventory) values (?, ?, ?)");
            ps.setString(1, obj.getStoreID());
            ps.setString(2, obj.getCity());
            ps.setString(3, obj.getSoulInventory());
        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save to the database.");
        }
    }
        @Override
        public void update (Store obj){

        }

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

        }

        @Override
        public Store getById (String id){
            return null;
        }

        @Override
        public List<Store> getAll () {
            List<Store> locations = new ArrayList<>();

            try (Connection con = ConnectionFactory.getInstance().getConnection()) {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM stores");
                ResultSet rs = ps.executeQuery();

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

            return locations;
        }

        public Store isStoreTakenDAO (String storeID){
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
    }

