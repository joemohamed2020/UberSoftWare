import java.sql.*;

public class FavArea {
    public void addFav(String src, String driverName)  {
        try {
            DataBase dataBase=new DataBase();
            Connection connection = DriverManager.getConnection(dataBase.getPath());
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO FavArea VALUES('"+driverName+"','"+src+"')");
            statement.close();
            connection.close();
        }
        catch (SQLException throwable) {
            System.out.println("Error!");;
        }
    }
    public void removeFav(String src,String driverName) {
        try {
            DataBase dataBase=new DataBase();
            Connection connection = DriverManager.getConnection(dataBase.getPath());
            Statement statement = connection.createStatement();
            statement.executeUpdate("Delete from FavArea where driverName='"+driverName+"'And Source='"+src+"'");
            connection.close();
            statement.close();
        } catch (SQLException throwables) {
            System.out.println("Error!");
        }

    }
    public void listFav(String driverName){
        try {
            DataBase dataBase=new DataBase();
            Connection connection = DriverManager.getConnection(dataBase.getPath());
            Statement statement = connection.createStatement();
            ResultSet source= statement.executeQuery("select Source from FavArea where driverName='"+driverName+"'");
            while (source.next()){
                System.out.println(source.getString("Source"));
            }
            connection.close();
            statement.close();
        } catch (SQLException throwables) {
            System.out.println("Error!");
        }
    }

}
