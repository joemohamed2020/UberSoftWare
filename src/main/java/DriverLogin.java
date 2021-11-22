import java.sql.*;
import java.util.Scanner;

public class DriverLogin implements ILogin {
    boolean login=false;

    public Person login() {
        Person driver = new Driver();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("UserName: ");
            String userName = scanner.next();
            System.out.print("Password: ");
            String password = scanner.next();
            ResultSet s = DataBase.getStatement().executeQuery("select * from Drivers");
            while (s.next()) {
                if (userName.equals(s.getString("driverName")) && password.equals(s.getString("Password"))) {
                    login = true;
                    break;
                }
            }

            if (login) {
                if (s.getInt("status")==1) {
                    System.out.println("Welcome Back:)");
                    System.out.println("==============");
                    driver = new Driver(s.getString("driverName"), s.getString("password"), s.getString("Email"), s.getString("PhoneNumber"), s.getString("licence"), s.getString("NationalId"));
                } else {
                    System.out.println("Your account has been suspended.");
                    login=false;
                }
            }
            else {
                System.out.println("UserName or Password is Wrong try again");
            }

        } catch (SQLException throwables) {
            System.out.println("Error!");
        }

        return driver;
    }

    public boolean isLogin() {
        return login;
    }
}
