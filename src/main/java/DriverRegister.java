import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DriverRegister implements IRegister {


    public void Register (){
        try{
            Connection connection= DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ymoha\\IdeaProjects\\Uber\\src\\data.db");
            Statement statement=connection.createStatement();
            Scanner scanner=new Scanner(System.in);
            System.out.print("UserName: ");
            String userName=scanner.next();
            System.out.print("Password: ");
            String password=scanner.next();
            System.out.print("Email(Optional): ");
            String email=scanner.next();
            System.out.print("PhoneNumber: ");
            String phone=scanner.next();
            System.out.print("licence: ");
            String licence=scanner.next();
            System.out.print("NationalID: ");
            String nationalId=scanner.next();
            statement.executeUpdate("INSERT INTO Drivers VALUES('"+userName+"','"+password+"','"+email+"','"+phone+"','"+licence+"','"+nationalId+"')");
            statement.close();
            connection.close();
        }
        catch (SQLException sql){
            System.out.println("This Driver is already exist!");
        }
    }
}
