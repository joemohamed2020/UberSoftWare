import java.sql.*;
import java.util.Scanner;

public class DriverLogin implements ILogin {
    boolean login=false;

    public Person login() {
        Person driver = new Driver();
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\youssef\\OneDrive\\Documents\\GitHub\\UberSoftWare\\src\\data.db");
            Statement statement = connection.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.print("UserName: ");
            String userName = scanner.next();
            System.out.print("Password: ");
            String password = scanner.next();
            ResultSet s = statement.executeQuery("select * from Drivers");
            while (s.next()) {
                if (userName.equals(s.getString("driverName")) && password.equals(s.getString("Password"))) {
                    login = true;
                    break;
                }
            }
            if (login) {
                System.out.println("Welcome Back:)");
                System.out.println("==============");
                driver = new Driver(s.getString("driverName"), s.getString("password"), s.getString("Email"), s.getString("PhoneNumber"), s.getString("licence"), s.getString("NationalId"));
            } else {
                System.out.println("UserName or Password is Wrong try again");
            }

            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            System.out.println("Error!");
        }

        return driver;
    }

    public boolean isLogin() {
        return login;
    }
}
