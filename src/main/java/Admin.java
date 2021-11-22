import java.sql.*;

public class Admin {
    private String name;
    private String Password;

    public Admin(String name, String password) {
        this.name = name;
        Password = password;
    }

    public void listPending(){
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
}