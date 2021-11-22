import java.sql.*;
import java.util.Scanner;

public class UserLogin implements ILogin {
    boolean login=false;
    @Override
    public Person login() {
        Person user = new User();
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\youssef\\OneDrive\\Documents\\GitHub\\UberSoftWare\\src\\data.db");
            Statement statement = connection.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.print("UserName: ");
            String userName = scanner.next();
            System.out.print("Password: ");
            String password = scanner.next();
            ResultSet s = statement.executeQuery("select * from users");
            while (s.next()) {
                if (userName.equals(s.getString("UserName")) && password.equals(s.getString("Password"))) {
                    login = true;
                    break;
                }
            }
            if (login) {
                System.out.println("Welcome Back:)");
                System.out.println("==============");
                user = new User(s.getString("UserName"), s.getString("Password"), s.getString("Email"), s.getString("PhoneNumber"));
            } else {
                System.out.println("UserName or Password is Wrong try again");
            }

            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            System.out.println("Error!");
        }

        return user;
    }

    public boolean isLogin() {
        return login;
    }
}
