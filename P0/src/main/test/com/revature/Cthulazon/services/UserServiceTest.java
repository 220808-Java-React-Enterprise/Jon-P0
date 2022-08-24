package com.revature.Cthulazon.services;

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

    /* jank constructor */
    @Before
    public void setup() {
        sut = new UserService(mockUserDao);
    }
public class UserServiceTest{

    @Test
    public void test_isValidUsername_givenCorrectUsername() {
        // Arrange
        String validUsername = "bduong0929";

        // Act
        boolean flag = sut.isValidUsername(validUsername);

        // Assert
        Assert.assertTrue(flag);
    }

}