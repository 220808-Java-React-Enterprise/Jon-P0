package com.revature.Cthulazon.services;
import com.revature.Cthulazon.dao.ProductDAO;
import com.revature.Cthulazon.models.Product;

public class ProductService {
    private final ProductDAO productDAO;

    public ProductService( ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void register(Product product) {
        productDAO.save(product);
    }

<<<<<<< Updated upstream
=======
    public List<Product> getAllAtStore(String storeID) {
        return productDAO.getAll(storeID);
    }
    public List<Product> getAllAvaliable(String storeID) {
        return productDAO.getAllAvailable(storeID);
    }
>>>>>>> Stashed changes

    public Product getById(String soulID){
        Product product=productDAO.getById(soulID);
        return product;
    }
}
