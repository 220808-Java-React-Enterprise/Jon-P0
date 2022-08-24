package com.revature.Cthulazon.services;
import com.revature.Cthulazon.dao.ProductDAO;
import com.revature.Cthulazon.models.Product;

import java.util.List;

public class ProductService {
    private final ProductDAO productDAO;

    public ProductService( ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void register(Product product) {
        productDAO.save(product);
    }

    public List<Product> getAllAtStore(String storeID) {
        return productDAO.getAll(storeID);
    }

public void availUpdate(String soulID)
{
    Product Temp=getById(soulID);
    productDAO.update(Temp);
}
    public Product getById(String soulID){
        Product product=productDAO.getById(soulID);
        return product;
    }
}
