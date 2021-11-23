import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserRegister implements IRegister {
    public void Register() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("UserName: ");
            String userName = scanner.next();
            System.out.print("Password: ");
            String password = scanner.next();
            String email=null;
            while (true) {
                System.out.println("Do you want to put your Email?Yes/No");
                String choose = scanner.next();
                if (choose.equalsIgnoreCase("yes")) {
                    System.out.print("Email:");
                    email = scanner.next();
                    break;
                } else if (choose.equalsIgnoreCase("no")) {
                    break;
                } else {
                    System.out.println("Wrong choose!");
                }
            }
            System.out.print("PhoneNumber: ");
            String phone = scanner.next();
            if (email!=null) {
                DataBase.getStatement().executeUpdate("INSERT INTO users VALUES('" + userName + "','" + password + "','" + email + "','" + phone + "',"+ 1 +")");
            }
            else {
                DataBase.getStatement().executeUpdate("INSERT INTO users VALUES('" + userName + "','" + password + "'," + null + ",'" + phone + "',"+ 1 +")");
            }
        } catch (SQLException sql) {
            System.out.println("This User is already exist!");
        }
    }
}
