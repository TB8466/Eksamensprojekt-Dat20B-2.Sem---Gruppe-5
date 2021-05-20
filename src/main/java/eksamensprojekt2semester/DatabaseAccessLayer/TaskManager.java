package eksamensprojekt2semester.DatabaseAccessLayer;

import eksamensprojekt2semester.Model.Project;
import eksamensprojekt2semester.Model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaskManager {
    public void createTask(Task task, int id) throws SQLException {
        Connection connection = DBManager.getConnection();
        String query = "INSERT INTO tasks (task_NAME, task_DESC, connected_project ) VALUES(?,?,?)"; //SQL query
        PreparedStatement preparedStatement = connection.prepareStatement(query); // Insert query into Ps

        preparedStatement.setString(1, task.getName());
        preparedStatement.setString(2, task.getDescription());
        preparedStatement.setInt(3,id);
        preparedStatement.executeUpdate();
    }

    public ArrayList<Task> viewTasks(int id) throws SQLException {
        Connection connection = DBManager.getConnection();
        String query = "SELECT * FROM tasks WHERE connected_project = ?";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        ArrayList<Task> taskList = new ArrayList<>();
        while(rs.next()){
            Task task = new Task(rs.getInt("task_id"), rs.getString("task_name"), rs.getString("task_desc"));
            taskList.add(task);
        }
        return taskList;
    }
}