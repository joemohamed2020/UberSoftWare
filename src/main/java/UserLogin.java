import java.sql.*;
import java.util.Scanner;

public class UserLogin implements ILogin {
    boolean login=false;
    @Override
    public Person login() {
        Person user = new User();
        try {
            DataBase dataBase=new DataBase();
            Connection connection = DriverManager.getConnection(dataBase.getPath());
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
                if (s.getInt("status")==1) {
                    System.out.println("Welcome Back:)");
                    System.out.println("==============");
                    user = new User(s.getString("UserName"), s.getString("Password"), s.getString("Email"), s.getString("PhoneNumber"));
                }
                else {
                    System.out.println("Your account has been suspended.");
                    login=false;
                }
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
