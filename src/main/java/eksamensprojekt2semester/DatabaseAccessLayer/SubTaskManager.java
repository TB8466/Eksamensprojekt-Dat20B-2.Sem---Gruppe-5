package eksamensprojekt2semester.DatabaseAccessLayer;

import eksamensprojekt2semester.Model.Project;
import eksamensprojekt2semester.Model.SubTask;
import eksamensprojekt2semester.Model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubTaskManager {
    public void createTask(SubTask subTask, Project project) throws SQLException {
        Connection connection = DBManager.getConnection();
        String query = "INSERT INTO tasks (tasks_NAME, tasks_DESC, connected_project ) VALUES(?,?,?)"; //SQL query
        PreparedStatement preparedStatement = connection.prepareStatement(query); // Insert query into Ps

        preparedStatement.setString(1, subTask.getName());
        preparedStatement.setString(2, subTask.getDesc());

        preparedStatement.executeUpdate();
    }
}
