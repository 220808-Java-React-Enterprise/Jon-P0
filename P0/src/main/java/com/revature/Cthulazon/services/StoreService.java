package com.revature.Cthulazon.services;
import com.revature.Cthulazon.dao.StoreDAO;
import com.revature.Cthulazon.models.Store;
import com.revature.Cthulazon.models.User;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidStoreException;

import java.util.List;
public class StoreService {
    private final StoreDAO storeDAO;

    public StoreService(StoreDAO storeDAO) {
        this.storeDAO = storeDAO;
    }

    public List<Store> getAllLocations() {
        return storeDAO.getAll();
    }


    public Store isValidStore(String location){
        Store store=storeDAO.isValidStoreDAO(location);
        if (store==null) throw new InvalidStoreException("/nStore does not exist");
        return store;
    }



    }
