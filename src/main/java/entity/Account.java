package entity;

public class Account {
    private String login;
    private String name;
    private String surname;
    private byte access;
    private String role;

    public Account(String login, String name, String surname, byte access, String role) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.access = access;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", access=" + access +
                ", role='" + role + '\'' +
                '}';
    }
}
