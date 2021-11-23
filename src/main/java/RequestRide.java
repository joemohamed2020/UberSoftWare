import java.sql.SQLException;
import java.util.Scanner;

public class RequestRide {
    private String src;
    private String dest;
    public RequestRide() {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter Source Location:");
        src=scanner.next();
        System.out.print("Enter Destination Location:");
        dest=scanner.next();
    }

    public void requestRide( String userName){
        try {
            DataBase.getStatement().executeUpdate("INSERT INTO PendingRide VALUES ('"+userName+"','"+src+"','"+dest+"',"+0+","+null+")");
            System.out.println("We are locking for Driver Now Please Wait");
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
