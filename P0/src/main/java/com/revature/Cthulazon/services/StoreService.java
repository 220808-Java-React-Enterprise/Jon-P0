package com.revature.Cthulazon.services;
import com.revature.Cthulazon.dao.StoreDAO;
import com.revature.Cthulazon.services.ProductService;
import com.revature.Cthulazon.dao.ProductDAO;
import com.revature.Cthulazon.models.Store;
import com.revature.Cthulazon.models.Product;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidSQLException;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidStoreException;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidUserException;

import java.util.List;
public class StoreService {
    private final StoreDAO storeDAO;

    public StoreService(StoreDAO storeDAO) {
        this.storeDAO = storeDAO;
    }

    public List<Store> getAllLocations() {
        return storeDAO.getAll();
    }

    public Store getAllStoreProducts(String storeID)
    {
        Store store=storeDAO.getById(storeID);
        return store;
    }
public Store getById(String storeID)
{
    Store store=storeDAO.getById(storeID);
    return store;
}
    public Store isValidStore(String storeID){
        Store store=storeDAO.isStoreTakenDAO(storeID);
            throw new InvalidUserException(("Store already taken"));
    }

    public Store isStoreTaken(String storeID){
        if(storeDAO.isStoreTakenDAO(storeID)!=null);
        throw new InvalidSQLException("Store is taken");
    }


    }
