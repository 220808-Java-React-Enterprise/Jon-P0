package com.revature.Cthulazon.services;
import com.revature.Cthulazon.dao.StoreDAO;
import com.revature.Cthulazon.models.Store;
import java.util.List;
public class StoreService {
    private final StoreDAO storeDAO;

    public StoreService(StoreDAO storeDAO) {
        this.storeDAO = storeDAO;
    }

    public List<Store> getAllLocations() {
        return storeDAO.getAll();
    }
}