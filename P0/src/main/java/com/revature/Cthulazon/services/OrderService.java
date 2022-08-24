package com.revature.Cthulazon.services;

import com.revature.Cthulazon.dao.OrderDAO;
import com.revature.Cthulazon.models.Orders;

import java.util.List;

public class OrderService {
    private final OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

  public void saveOrder(Orders order){
        orderDAO.save(order);
    }

    public List<Orders> getHistory()
    {
        return orderDAO.getAll();
    }

    public List<Orders> getHistoryOfStore(String storeID)
    {
        return orderDAO.getByStore(storeID);
    }
}
