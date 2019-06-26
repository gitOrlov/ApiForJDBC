package dao;

import entity.Account;

import java.sql.*;

public class AccountDAOImpl implements AccountDAO{

    @Override
    public Account getAccountByLogin(String login) {
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * from accounts WHERE login = ?")){
            statement.setString(1, login);
            ResultSet set = statement.executeQuery();

            if (set.next()){
                String name = set.getString(2);
                String surname = set.getString(3);
                byte access = set.getByte(4);
                String role = set.getString(5);

                Account account = new Account(login, name, surname, access, role);
                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateSurname(String login, String surname) {
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE accounts SET surname = ? WHERE login = ?")) {
            statement.setString(1, surname);
            statement.setString(2, login);
            int updated = statement.executeUpdate();

            if (updated == 1) System.out.println("Surname updated!");
            else System.out.println("Error update!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public String getSurname(String login){
        try(Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT surname FROM accounts WHERE login = ?")){
            statement.setString(1, login);
            ResultSet set = statement.executeQuery();

            if (set.next()){
                String surname = set.getString(1);
                return surname;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    private Connection getConnection() {
        final String driverName = "jdbc:mysql://localhost:3306/repository?serverTimezone=UTC";
        final String login = "root";
        final String password = "root";

        try{
            Connection connection = DriverManager.getConnection(driverName, login, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
