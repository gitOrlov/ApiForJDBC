package dao;

import entity.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AccountDAOImplTest {
    Account testAccount = new Account("Test", "Name", "Surname", (byte)1, "test");

    @Mock
    AccountDAOImpl testAccountDAOImpl;

    @Mock
    PreparedStatement ps;

    @Mock
    ResultSet resultSet;

    @Mock
    Connection connection;

    @Test
    public void statementTest(){
        try {
           when(ps.executeQuery()).thenReturn(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void connectionTest(){
        try {
            when(connection.createStatement()).thenReturn(ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAccountByLogin() {
        when(testAccountDAOImpl.getAccountByLogin("Test")).thenReturn(testAccount);
        assertEquals(testAccountDAOImpl.getAccountByLogin("Test"), testAccount);
        verify(testAccountDAOImpl).getAccountByLogin("Test");
    }

    @Test
    public void updateSurname() {
        doCallRealMethod().when(testAccountDAOImpl).updateSurname("Testt", "NewSurname");
        testAccountDAOImpl.updateSurname("Test", "NewSurname");
    }

    @Test
    public void getSurname() {
        when(testAccountDAOImpl.getSurname("Surname")).thenReturn("Test");
        assertEquals(testAccountDAOImpl.getSurname("Surname"), "Test");
        verify(testAccountDAOImpl).getSurname("Surname");
    }
}