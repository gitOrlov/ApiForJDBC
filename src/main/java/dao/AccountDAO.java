package dao;

import entity.Account;

public interface AccountDAO {

    Account getAccountByLogin(String login);

    void updateSurname(String login, String surname);

    String getSurname(String login);
}
