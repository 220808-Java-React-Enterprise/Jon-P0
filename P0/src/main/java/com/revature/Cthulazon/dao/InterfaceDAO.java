package com.revature.Cthulazon.dao;
import java.io.IOException;
import java.util.List;


    public interface InterfaceDAO<T> {
        void save(T obj) throws IOException;
        void update(T obj);
        void delete(String id);
        T getById(String id);
        List<T> getAll();
    }

