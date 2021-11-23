import java.sql.SQLException;
import java.util.Scanner;

public class Offer {
    public static void Offer(String driverName) {
        Scanner scanner = new Scanner(System.in);
        try {
            if (ListPendingRides.List(driverName)) {
                System.out.println("Do you want to make your Offer?yes/no");
                String input = scanner.next();
                if (input.equalsIgnoreCase("yes")) {
                    System.out.print("Enter UserName :");
                    input=scanner.next();
                    System.out.print("Enter your Offer:");
                    float offer = scanner.nextFloat();
                    DataBase.getStatement().executeUpdate("Update PendingRide set offer="+offer+" , driverName='"+driverName+"' where userName='"+input+"'");
                }
            }
        } catch (SQLException throwables) {
            System.out.println("Error!");
        }
    }
}
