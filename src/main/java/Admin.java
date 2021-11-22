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

            ResultSet pendingDriver= DataBase.getStatement().executeQuery("select * from Drivers where status=0");
            while (pendingDriver.next()){
                System.out.println("======================\nDriverName:"+pendingDriver.getString("driverName")
                        +"\nEmail:"+pendingDriver.getString("Email")
                        +"\nPhoneNumber" +pendingDriver.getString("phoneNumber")
                        +"\nLicence:"+pendingDriver.getString("licence")
                        +"\nNationalId:"+pendingDriver.getString("NationalId"));
            }
        } catch (SQLException throwables) {
            System.out.println("Error!");
        }
    }
    public void verifyDriver(String driverName){
        try {
            DataBase.getStatement().executeUpdate("update Drivers set status=1 where driverName='"+driverName+"'");
        } catch (SQLException throwables) {
            System.out.println("Error!");
        }

    }
    public void verifyUser(String UserName){
        try {
            DataBase.getStatement().executeUpdate("update users set status=1 where UserName='"+UserName+"'");
        } catch (SQLException throwables) {
            System.out.println("Error!");
        }

    }
    public void suspendDriver(String driverName){
        try {
            DataBase.getStatement().executeUpdate("update Drivers set status=0 where driverName='"+driverName+"'");
        }
        catch (SQLException throwables) {
            System.out.println("Error!");
        }

    }
    public void suspendUser(String userName){
        try {
            DataBase.getStatement().executeUpdate("update users set status=0 where userName='"+userName+"'");
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
