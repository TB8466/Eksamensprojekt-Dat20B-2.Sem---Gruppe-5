package eksamensprojekt2semester.DatabaseAccessLayer;

import eksamensprojekt2semester.Model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    //Tests that when a project is created and inserted into the database,
    //that the data then can be received from the database and used as data in Java

    //Resets the test
    @BeforeEach
    void reset() throws SQLException {
        ProjectManager projectManager = new ProjectManager();
        projectManager.deleteProject(1000);
    }
    //Inserts a "dummy"-project
    @BeforeEach //Do something Before Each Test
     void setup() throws SQLException {
        Connection connection = DBManager.getConnection();
        String query = "INSERT INTO projects (PROJECT_NAME, PROJECT_DESC, PROJECT_ID) VALUES('Project1','Project1desc', 1000)"; //SQL query
        PreparedStatement preparedStatement = connection.prepareStatement(query); // Insert query into Ps

        preparedStatement.executeUpdate();
    }

    //Inserts a task into database
    @BeforeEach
    void createTask() throws SQLException {
        Connection connection = DBManager.getConnection();
        String query = "INSERT INTO tasks (task_NAME, task_DESC, connected_project ) VALUES('testname','testdesc',1000)"; //SQL query
        PreparedStatement preparedStatement = connection.prepareStatement(query); // Insert query into Ps

        preparedStatement.executeUpdate();
    }

    //Receives task from database
    @Test
    void getTasks() throws SQLException {
        Connection connection = DBManager.getConnection();

        String query ="select * from tasks where task_name='testname' and task_desc='testdesc' and connected_project=1000 ";
        PreparedStatement ps = connection.prepareStatement(query); // Insert query into Ps

        ResultSet rs = ps.executeQuery();
        rs.next();

        String name = rs.getString("task_name");
        String desc = rs.getString("task_desc");
        int id = rs.getInt("connected_project");

        assertEquals("testname",name);
        assertEquals("testdesc",desc);
        assertEquals(1000, id);
    }
}