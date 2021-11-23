import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverRate {
    public float AVGRate(String driverName){
        float AVGRate=0;
        try {
            ResultSet rate=DataBase.getStatement().executeQuery("SELECT avg(Rate)FROM RequestRide where driverName='"+driverName+"'");
            AVGRate=rate.getFloat("avg(Rate)");

        }
        catch (SQLException throwables) {
            System.out.println("Error!");
        }

        return AVGRate;
    }

}
