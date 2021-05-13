package eksamensprojekt2semester;

import eksamensprojekt2semester.DatabaseAccessLayer.DBManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EksamensProjekt2SemesterApplication {

    public static void main(String[] args) {
        SpringApplication.run(EksamensProjekt2SemesterApplication.class, args);
        DBManager.getConnection();
    }

}