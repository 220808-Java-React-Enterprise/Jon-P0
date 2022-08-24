package com.revature.Cthulazon.services;

import com.revature.Cthulazon.dao.OrderDAO;
import com.revature.Cthulazon.dao.ProductDAO;
import com.revature.Cthulazon.dao.StoreDAO;
import com.revature.Cthulazon.models.Orders;
import com.revature.Cthulazon.models.Product;
import com.revature.Cthulazon.models.Store;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderServiceTest {
    private OrderService orderSut; // sut = system under test
    private ProductService productSut;
    private final OrderDAO mockOrderDAO = mock(OrderDAO.class);
    private final ProductDAO mockProductDAO = mock(ProductDAO.class);


    @Test
    public void getHistory() {
        String validStore = "store1234";
        ProductService spiedProd = Mockito.spy(productSut);
        OrderService spiedOrder = Mockito.spy(orderSut);
        Orders order= (Orders) when(mockOrderDAO.getById(validStore)).thenReturn(new Orders());
        Assert.assertNotNull(order);

    }

}

