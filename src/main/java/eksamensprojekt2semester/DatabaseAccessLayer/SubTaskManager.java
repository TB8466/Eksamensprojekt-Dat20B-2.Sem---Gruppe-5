package eksamensprojekt2semester.DatabaseAccessLayer;

import eksamensprojekt2semester.Model.Project;
import eksamensprojekt2semester.Model.SubTask;
import eksamensprojekt2semester.Model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubTaskManager {
    public void createSubTask(SubTask subTask, int id) throws SQLException {
        Connection connection = DBManager.getConnection();
        String query = "INSERT INTO subtasks (subtask_NAME, subtask_DESC, estimated_time, connected_task ) VALUES(?,?,?,?)"; //SQL query
        PreparedStatement preparedStatement = connection.prepareStatement(query); // Insert query into Ps

        preparedStatement.setString(1, subTask.getName());
        preparedStatement.setString(2, subTask.getDesc());
        preparedStatement.setDouble(3, subTask.getEstimatedTime());
        preparedStatement.setInt(4, id);
        preparedStatement.executeUpdate();
    }
}
