package eksamensprojekt2semester.DatabaseAccessLayer;

import org.springframework.core.io.ClassPathResource;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {

    private static String user;
    private static String password;
    private static String url;

    private static Connection connection = null;

    //Primary connection method -- Establishes connection to mySQL database
    public static Connection getConnection() {
        //Check if connection is already established
        if (connection != null) {
            return connection;
        }

        try (InputStream input = new ClassPathResource("application.properties").getInputStream())
        {
            //Properties object is used to get data from application.properties file
            Properties properties = new Properties();
            properties.load(input);
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");

        } catch (IOException e) {
            e.printStackTrace();
        } try {
            //Java considers this method obsolete, but it is currently our only way to get a .war file to correctly find the JDBC Driver
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Where is your MySQL JDBC Driver?");
                e.printStackTrace();
            }
            //Insert information from application.properties and establish connection
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Der er forbindelse");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Der er ikke forbindelse");

        }
        return connection;
    }
}