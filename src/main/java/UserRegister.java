import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserRegister implements IRegister {
    public void Register() {
        try {
            DataBase dataBase=new DataBase();
            Connection connection = DriverManager.getConnection(dataBase.getPath());
            Statement statement = connection.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.print("UserName: ");
            String userName = scanner.next();
            System.out.print("Password: ");
            String password = scanner.next();
            System.out.print("Email(Optional): ");
            String email = scanner.next();
            System.out.print("PhoneNumber: ");
            String phone = scanner.next();
            if (!email.equals(null)) {
                statement.executeUpdate("INSERT INTO users VALUES('" + userName + "','" + password + "','" + email + "','" + phone + "',"+ 1 +")");
            }
            else {
                statement.executeUpdate("INSERT INTO users VALUES('" + userName + "','" + password + "','" + email + "','" + phone + "')");
            }
            statement.close();
            connection.close();
        } catch (SQLException sql) {
            System.out.println("This User is already exist!");
        }
    }
}
