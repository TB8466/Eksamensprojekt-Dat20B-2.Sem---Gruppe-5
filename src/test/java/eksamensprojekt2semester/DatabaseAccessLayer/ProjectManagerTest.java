package eksamensprojekt2semester.DatabaseAccessLayer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ProjectManagerTest {

    @BeforeEach //Do something Before Each Test
    public void setup() throws SQLException {
        Connection connection = DBManager.getConnection();
        String query = "INSERT INTO projects (PROJECT_NAME, PROJECT_DESC) VALUES('Project1','Project1desc')"; //SQL query
        PreparedStatement preparedStatement = connection.prepareStatement(query); // Insert query into Ps

        preparedStatement.executeUpdate();
    }

    @Test
    void createProject() throws SQLException {
        Connection connection = DBManager.getConnection();

        String name ="";
        String desc ="";

        String query = "SELECT * from projects WHERE project_name='Project1' AND project_desc='Project1desc'";
        PreparedStatement ps = connection.prepareStatement(query);

        ResultSet rs = ps.executeQuery();
        rs.next();
             name = rs.getString("project_name");
             desc = rs.getString("project_desc");


        assertEquals("Project1",name);
        assertEquals("Project1desc",desc);

    }
}