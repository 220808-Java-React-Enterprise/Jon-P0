package com.revature.Cthulazon.services;
import com.revature.Cthulazon.dao.ProductDAO;
import com.revature.Cthulazon.models.Product;
import com.revature.Cthulazon.models.Store;

import java.util.List;

public class ProductService {
    private final ProductDAO productDAO;

    public ProductService( ProductDAO productDAO) {
        this.productDAO= productDAO;
    }

    public void register(Product product) {
        productDAO.save(product);
    }




    public List<Product>  getAllAtStore(String storeID) {
        return productDAO.getAll(storeID);
    }

    public List<Product> getAllAvaliable(String storeID) {
        return productDAO.getAllAvailable(storeID);
    }




    public void availUpdate(String soulID)
    {

        productDAO.update(productDAO.getById(soulID));
    }

    public Product getById(String soulID){
       return  productDAO.getById(soulID);

    }
}

