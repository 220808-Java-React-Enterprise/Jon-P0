package com.revature.Cthulazon.services;
import com.revature.Cthulazon.models.Store;
import com.revature.Cthulazon.utils.Custom_Exceptions.*;
import com.revature.Cthulazon.dao.StoreDAO;
import org.junit.Test;

import org.junit.Before;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;


public class StoreServiceTest {
    private StoreService storeSut;
    private final StoreDAO mockStoreDAO=mock(StoreDAO.class);

    @Before
    public void setup() {
        storeSut = new StoreService(mockStoreDAO);
    }




    @Test
    public void test_isStoreTakenIsNotTaken() {
            StoreService spiedSut = Mockito.spy(storeSut);
            String storeNum = "1234";
            when(mockStoreDAO.isStoreTakenDAO(storeNum) == null);


        }
@Test
        public void test_isStoreTakenIsTaken () {
            // Arrange
            StoreService spiedSut = Mockito.spy(storeSut);
            String storeNum = "124";
            when(mockStoreDAO.isStoreTakenDAO(storeNum) != null);

        }




        @Test
    public void test_getByIdDoesReturn()
        {
            StoreService spiedSut = Mockito.spy(storeSut);
            String number="123";
            when(mockStoreDAO.getById(number) != null);


        }




}