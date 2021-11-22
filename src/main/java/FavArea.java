import java.sql.*;

public class FavArea {
    public void addFav(String src, String driverName)  {
        try {
            DataBase.getStatement().executeUpdate("INSERT INTO FavArea VALUES('"+driverName+"','"+src+"')");

        }
        catch (SQLException throwable) {
            System.out.println("Error!");;
        }
    }
    public void removeFav(String src,String driverName) {
        try {
            DataBase.getStatement().executeUpdate("Delete from FavArea where driverName='"+driverName+"'And Source='"+src+"'");
        } catch (SQLException throwables) {
            System.out.println("Error!");
        }

    }
    public void listFav(String driverName){
        try {
            ResultSet source= DataBase.getStatement().executeQuery("select Source from FavArea where driverName='"+driverName+"'");
            while (source.next()){
                System.out.println(source.getString("Source"));
            }
        } catch (SQLException throwables) {
            System.out.println("Error!");
        }
    }

}
