import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    private static Connection connection;
    private static Statement statement;
    public static void connect() {
        try {
             connection = DriverManager.getConnection("jdbc:sqlite:data.db");
            statement=connection.createStatement();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void disconnect(){
        try {
            statement.close();
            connection.close();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static Statement getStatement() {
        return statement;
    }
}
