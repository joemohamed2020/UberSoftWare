import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MyPendingRides {
    public static void MyPendingRides(String username){
        int count=0;
        Scanner scanner=new Scanner(System.in);
        try{
           ResultSet r= DataBase.getStatement().executeQuery("select * from PendingRide where userName='"+username+"'");
           while (r.next()){
               count++;
               if (r.getFloat("offer")==0){
               System.out.println("=================\nSource:"+r.getString("source")+"\nDestination:"+r.getString("destination")+"\n=================");
               break;
               }
               else{
                   ResultSet s=DataBase.getStatement().executeQuery("select * from Drivers,PendingRide where userName='"+username+"'and Drivers.driverName=PendingRide.driverName");
                   System.out.println("=================" +
                           "\nDriverName:"+s.getString("driverName")+
                           "\nRate:"+s.getString("AVGRate")+
                           "\nSource:"+s.getString("source")+
                           "\nDestination:"+s.getString("destination")+
                           "\nOffer:"+s.getString("offer")+"\n=================");
                   System.out.println("Do you Accept this offer?yes/no");
                   String input=scanner.next();
                   if (input.equalsIgnoreCase("yes")){
                       DataBase.getStatement().executeUpdate("INSERT INTO Ride (driverName, userName, source, destination,Rate, Price) values('"+r.getString("driverName")
                               +"','"+username
                               +"','"+r.getString("source")
                               +"','"+r.getString("destination")
                               +"',"+-1
                               +","+r.getFloat("offer")
                               +")");
                       DataBase.getStatement().executeUpdate("Delete from PendingRide where userName='"+username+"'");
                   }
                   else{
                       DataBase.getStatement().executeUpdate("update PendingRide set offer=0 where userName='"+username+"'");
                   }
               }
           }
           if (count==0){
               System.out.println("There is no Pending Rides For you");
           }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error!");
        }
    }
}
