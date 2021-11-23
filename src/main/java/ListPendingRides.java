import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ListPendingRides {
    public static boolean List(String driverName){
        Scanner scanner=new Scanner(System.in);
        boolean x=false;
        try{
            ResultSet list=DataBase.getStatement().executeQuery("SELECT userName,PendingRide.source,destination from PendingRide,FavArea WHERE FavArea.driverName='"+driverName+"'And PendingRide.source=FavArea.source");
            while (list.next()){
                System.out.println("================\nUserName:"+list.getString("userName")+"\nSource:"+list.getString("source")+"\nDestination:"+list.getString("destination")+"\n================");
                x=true;
            }

        }
        catch (SQLException throwables) {
            System.out.println("Error!");
        }
        return x;
    }
}
