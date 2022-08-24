package com.revature.Cthulazon.services;
import com.revature.Cthulazon.dao.ProductDAO;
import com.revature.Cthulazon.dao.StoreDAO;
import com.revature.Cthulazon.dao.UserDAO;
import com.revature.Cthulazon.models.Product;
import com.revature.Cthulazon.models.Store;
import junit.framework.TestCase;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ProductServiceTest{
    private ProductService productSut; // sut = system under test
    private StoreService storeSut;
    private final StoreDAO mockStoreDAO=mock(StoreDAO.class);


    private final ProductDAO mockProductDAO = mock(ProductDAO.class);

    @Before
    public void setup() {
        productSut = new ProductService(mockProductDAO);
        storeSut = new StoreService(mockStoreDAO);
    }




@Test
    public void getByValidId(){

            ProductService spiedSut = Mockito.spy(productSut);
            String number="1234";
            when(mockProductDAO.getById(number) != null);


    }
@Test
    public void getByInValidId(){

        ProductService spiedSut = Mockito.spy(productSut);
        String number="1234";
        when(mockProductDAO.getById(number) == null);


    }
    @Test
    public void getAllAvaliable()
    {
        List<Product> list=new ArrayList<>();
        ProductService spiedSut=Mockito.spy(productSut);
        StoreService spiedStore=Mockito.spy(storeSut);
        String Storenumber="123";
        when(mockProductDAO.getAllAvailable(Storenumber)).thenReturn(list);

        Assert.assertNotNull(list);


    }
}