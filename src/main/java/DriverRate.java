import java.sql.*;
import java.util.Scanner;

public class DriverRate {
    public static float AVGRate(String driverName){
        float AVGRate=0;
        try {
            ResultSet rate=DataBase.getStatement().executeQuery("SELECT avg(Rate) FROM Ride where driverName='"+driverName+"'");
            AVGRate=rate.getFloat(1);
            DataBase.getStatement().executeUpdate("update Drivers set AVGRate="+AVGRate+" where driverName='"+driverName+"'");
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error!");
        }

        return AVGRate;
    }
    public static void Rate(String userName){
        int id=0;
        float rate1=0;
        String driverName="";
        try{
            ResultSet resultSet=DataBase.getStatement().executeQuery("SELECT * FROM Ride where userName='"+userName+"'");
            while (resultSet.next()){
                id=resultSet.getInt("Id");
                rate1=resultSet.getFloat("Rate");
                driverName=resultSet.getString("driverName");
            }
            if (rate1!=-1){
                System.out.println("There is no Rides to Rate!!");
            }
            else {
                Scanner scanner=new Scanner(System.in);

                while (true){
                    System.out.print("Enter Rate For Driver from 0 to 5:");
                    float rate=scanner.nextFloat();
                    if (rate<5&&rate>0) {
                        DataBase.getStatement().executeUpdate("update Ride set Rate=" + rate + " where Id=" + id + "");
                        DriverRate.AVGRate(driverName);
                        break;
                    }
                    else{
                        System.out.println("Rate form 0 to 5 :)!");
                    }
                }

            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error!");
        }


    }
}
