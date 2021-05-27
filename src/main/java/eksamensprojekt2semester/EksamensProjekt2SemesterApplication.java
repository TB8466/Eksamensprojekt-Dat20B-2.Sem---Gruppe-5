package eksamensprojekt2semester;

import com.mysql.cj.protocol.Resultset;
import eksamensprojekt2semester.DatabaseAccessLayer.DBManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class EksamensProjekt2SemesterApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(EksamensProjekt2SemesterApplication.class, args);
    }
}