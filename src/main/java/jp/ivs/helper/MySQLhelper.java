package jp.ivs.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLhelper
{
    private static String jdbcURL="jdbc:mysql://localhost:3306/groot";
    private static String jdbcUsername="thomc";
    private static String jdbcPassword="12345678";

    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;

    public static Connection connectDB(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException
    {
        if (jdbcURL.equals("") || jdbcUsername.equals(""))
            return connectToMySQL();
        Connection jdbcConnection=null;
       findDriver();
        try {
            if (jdbcURL.equals("")) jdbcURL = MySQLhelper.jdbcURL;
            if (jdbcUsername.equals("")) jdbcUsername = MySQLhelper.jdbcUsername;
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException ex)
        {
            System.err.println("Lỗi: " + ex.getMessage());
        }
        return jdbcConnection;
    }
    public static void setUseDb(Connection connection, String dbName)
    {
        try {
            statement = connection.createStatement();
            statement.executeQuery("use "+dbName);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    static void findDriver() throws SQLException
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e)
        {
            throw new SQLException(e);
        }
    }
    public static Connection connectToMySQL() throws SQLException
    {
        Connection jdbcConnection=null;
        findDriver();
        try {
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException ex)
        {
            System.err.println("Lỗi: " + ex.getMessage());
        }
        return jdbcConnection;
    }
}
