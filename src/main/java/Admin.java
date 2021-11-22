import java.sql.*;
public class Admin {
    private String name;
    private String Password;

    public Admin(String name, String password) {
        this.name = name;
        Password = password;
    }

    public void listPending() {
        try {
            DataBase dataBase=new DataBase();
            Connection connection = DriverManager.getConnection(dataBase.getPath());
            Statement statement = connection.createStatement();
            ResultSet pendingDriver= statement.executeQuery("select * from Drivers where status=0");
            while (pendingDriver.next()){
                System.out.println("======================\nDriverName:"+pendingDriver.getString("driverName")
                        +"\nEmail:"+pendingDriver.getString("Email")
                        +"\nPhoneNumber" +pendingDriver.getString("phoneNumber")
                        +"\nLicence:"+pendingDriver.getString("licence")
                        +"\nNationalId:"+pendingDriver.getString("NationalId"));
            }
            connection.close();
            statement.close();
        } catch (SQLException throwables) {
            System.out.println("Error!");
        }
    }
    public void verifyDriver(String driverName){
        try {
            DataBase dataBase=new DataBase();
            Connection connection = DriverManager.getConnection(dataBase.getPath());
            Statement statement = connection.createStatement();
            statement.executeUpdate("update Drivers set status=1 where driverName='"+driverName+"'");
            connection.close();
            statement.close();
        } catch (SQLException throwables) {
            System.out.println("Error!");
        }

    }
    public void verifyUser(String UserName){
        try {
            DataBase dataBase=new DataBase();
            Connection connection = DriverManager.getConnection(dataBase.getPath());
            Statement statement = connection.createStatement();
            statement.executeUpdate("update users set status=1 where UserName='"+UserName+"'");
            connection.close();
            statement.close();
        } catch (SQLException throwables) {
            System.out.println("Error!");
        }

    }
    public void suspendDriver(String driverName){
        try {
            DataBase dataBase=new DataBase();
            Connection connection = DriverManager.getConnection(dataBase.getPath());
            Statement statement = connection.createStatement();
            statement.executeUpdate("update Drivers set status=0 where driverName='"+driverName+"'");
            connection.close();
            statement.close();
        }
        catch (SQLException throwables) {
            System.out.println("Error!");
        }

    }
    public void suspendUser(String userName){
        try {
            DataBase dataBase=new DataBase();
            Connection connection = DriverManager.getConnection(dataBase.getPath());
            Statement statement = connection.createStatement();
            statement.executeUpdate("update users set status=0 where userName='"+userName+"'");
            connection.close();
            statement.close();
        }
        catch (SQLException throwables) {
            System.out.println("Error!");
        }

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
