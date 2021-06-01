package eksamensprojekt2semester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.SQLException;

@SpringBootApplication
public class EksamensProjekt2SemesterApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(EksamensProjekt2SemesterApplication.class, args);
    }
}