package com.revature.Cthulazon.services;
import com.revature.Cthulazon.dao.StoreDAO;
import com.revature.Cthulazon.models.Store;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidSQLException;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidStoreException;

import java.util.ArrayList;
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

    public void register(Store store) {
        storeDAO.save(store);
    }


public Store getById(String storeID)
{
    Store store=storeDAO.getById(storeID);
    return store;
}
public  void isValidCity(String city)
{

    List<String> listOfCity = new ArrayList();
    listOfCity.add("jacksonville");
    listOfCity.add("newyork");
    listOfCity.add("dallas");

    if(!listOfCity.contains(city))
        throw new InvalidStoreException(city + " Is not allowed and no spaces are allowed, Choose: jacksonville, newyork, dallas");
}



    public void isStoreTaken(String storeNumber){
        if(storeDAO.getStoreNumber(storeNumber)!=null)
        throw new InvalidSQLException("Store is taken");
    }


    }
