package com.revature.Cthulazon.services;

import com.revature.Cthulazon.dao.StoreDAO;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidSQLException;
import junit.framework.TestCase;
import org.junit.Test;
import com.revature.Cthulazon.dao.UserDAO;
import com.revature.Cthulazon.models.User;
import com.revature.Cthulazon.utils.Custom_Exceptions.InvalidUserException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class UserServiceTest {

    /* dependency injection */
    private UserService sut; // sut = system under test

    private final UserDAO mockUserDao = mock(UserDAO.class);

    @Before
    public void setup() {
        sut = new UserService(mockUserDao);
    }

    @Test
    public void test_isValidUsername_givenCorrectUsername() {
        // Arrange
        String validUsername = "JonTrans95";

        // Act
        boolean flag=sut.isValidUsername(validUsername);


        // Assert
        Assert.assertTrue(flag);
    }

    @Test
    public void test_passWordIsValid()
    {

        String validPassword="JonTrans95";
       boolean flag=sut.isValidPassword(validPassword);


        Assert.assertTrue(flag);
    }

    @Test
    public void test_login_validLoginGivenCorrectCredentials() {
        // Arrange
        UserService spiedSut = Mockito.spy(sut);
        String validUsername = "JonTrans95";
        String validPassword = "JonTrans95";
        when(spiedSut.isValidUsername(validUsername)).thenReturn(true);
        when(spiedSut.isValidPassword(validPassword)).thenReturn(true);
        when(mockUserDao.getUserByUsernameAndPassword(validUsername, validPassword)).thenReturn(new User());

        // Act
        User user = spiedSut.login(validUsername, validPassword);

        // Assert
        Assert.assertNotNull(user);
        verify(mockUserDao, times(1)).getUserByUsernameAndPassword(validUsername, validPassword);
    }




}