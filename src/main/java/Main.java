import dao.AccountDAO;
import dao.DAOFactory;
import entity.Account;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DAOFactory factory = DAOFactory.getInstance();
        AccountDAO accountDAO = factory.getAccountDAO();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! Enter task:");

        while (true) {
            System.out.println("1. Search account in DB");
            System.out.println("2. Change account Surname");

            try{
                int decision = Integer.parseInt(scanner.nextLine());

                if (decision == 1) {
                    System.out.println("Enter the login...");
                    String login = scanner.nextLine();
                    scanner.close();

                    Account account = accountDAO.getAccountByLogin(login);
                    System.out.println(account);
                    break;
                }

                if (decision == 2) {
                    System.out.println("Enter the login...");
                    String login = scanner.nextLine();

                    String currentSurname = accountDAO.getSurname(login);
                    System.out.println("Current surname " + currentSurname);

                    System.out.println("Enter new surname...");
                    String surname = scanner.nextLine();
                    scanner.close();

                    accountDAO.updateSurname(login, surname);
                    break;
                }

                else
                    System.out.println("Wrong decision, enter correct task..");
            }catch(NumberFormatException e){
                System.out.println("Wrong decision, enter correct task..");
            }
        }
    }
}
