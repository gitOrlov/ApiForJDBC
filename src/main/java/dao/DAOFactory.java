package dao;

public class DAOFactory {
    private static DAOFactory factory;

    private DAOFactory(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("driver loading error");
        }
    }

    public static synchronized DAOFactory getInstance(){
        if (factory == null)
            factory = new DAOFactory();
        return  factory;
    }

    public AccountDAO getAccountDAO(){
        return new AccountDAOImpl();
    }
}
