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

    @BeforeEach
    void reset() throws SQLException {
        Connection connection = DBManager.getConnection();
        String query = "delete from  projects where project_id = 1000";
        PreparedStatement preparedStatement = connection.prepareStatement(query); // Insert query into Ps

        preparedStatement.executeUpdate();
    }




    @BeforeEach //Do something Before Each Test
    public void setup() throws SQLException {
        Connection connection = DBManager.getConnection();
        String query = "INSERT INTO projects (PROJECT_NAME, PROJECT_DESC, PROJECT_ID) VALUES('Project1','Project1desc', 1000)"; //SQL query
        PreparedStatement preparedStatement = connection.prepareStatement(query); // Insert query into Ps

        preparedStatement.executeUpdate();
    }


    @BeforeEach
    void createTask() throws SQLException {
        Connection connection = DBManager.getConnection();
        String query = "INSERT INTO tasks (task_NAME, task_DESC, connected_project ) VALUES('testname','testdesc',1000)"; //SQL query
        PreparedStatement preparedStatement = connection.prepareStatement(query); // Insert query into Ps

        preparedStatement.executeUpdate();
    }




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