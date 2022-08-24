package com.revature.Cthulazon.dao;


import com.revature.Cthulazon.models.Product;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidSQLException;
import com.revature.Cthulazon.utils.database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDAO implements InterfaceDAO<Product>{
    @Override
    public void save(Product obj) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO product(soulID,sanityGrade,costToBuy,avaliable,storeid) values (?, ? ,?,?,?)");
            ps.setString(1, obj.getSoulID());
            ps.setString(2, obj.getSanityGrade());
            ps.setInt(3, obj.getCostToBuy());
            ps.setBoolean(4,  obj.isAvaliable());
            ps.setString(5,obj.getStoreID());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save Cart to the database.");
        }
    }

    public void update(Product obj) {

    }

    @Override
    public void delete(String id) {

    }


    @Override
    public Product getById(String soulID) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE soulID = ?");
            ps.setString(1, soulID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Product(rs.getString("soulID"), rs.getString("sanityGrade"), rs.getString("StoreID"),rs.getInt("costToBuy"),rs.getBoolean("Avaliable"));
            }

        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to access User Cart from the database.");
        }

        return null;
    }

    @Override
<<<<<<< Updated upstream
    public List<Product> getAll () {
        return null;
=======
    public List<Product> getAll()   {
        List<Product> listOfProduct = null;
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM products");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                listOfProduct.add(new Product(rs.getString("soulID"), rs.getString("SanityGrade"), rs.getInt("costToBuy"), rs.getBoolean("avaliable"), rs.getString("StoreID")));

            }
        }catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save Cart to the database.");
        }
        return listOfProduct;
    }



    public List<Product> getAll(String storeId)   {
        List<Product> listOfProduct=new ArrayList();
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE storeid=?");
            ps.setString(1, storeId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
              listOfProduct.add(new Product(rs.getString("soulID"), rs.getString("SanityGrade"),  rs.getInt("costToBuy"), rs.getBoolean("avaliable"),rs.getString("StoreID")));

            }
        }catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save Cart to the database.");
        }

        return listOfProduct;
>>>>>>> Stashed changes
    }
    public List<Product> getAllAvailable(String storeId)   {
        List<Product> listOfProduct=new ArrayList();
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE storeid=? AND avaliable=?");
            ps.setString(1, storeId);
            ps.setBoolean(2,true);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                listOfProduct.add(new Product(rs.getString("soulID"), rs.getString("SanityGrade"),  rs.getInt("costToBuy"), rs.getBoolean("avaliable"),rs.getString("StoreID")));

            }
        }catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save Cart to the database.");
        }

        return listOfProduct;
    }


}



