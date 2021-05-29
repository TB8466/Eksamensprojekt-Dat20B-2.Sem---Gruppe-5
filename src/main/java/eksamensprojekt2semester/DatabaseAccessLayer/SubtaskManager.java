package eksamensprojekt2semester.DatabaseAccessLayer;

import eksamensprojekt2semester.Model.Subtask;
import eksamensprojekt2semester.Model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubtaskManager {
    public void createSubtask(Subtask subtask, int id) throws SQLException {
        Connection connection = DBManager.getConnection();
        String query = "INSERT INTO subtasks (subtask_NAME, subtask_DESC, estimated_time, connected_task ) VALUES(?,?,?,?)"; //SQL query
        PreparedStatement preparedStatement = connection.prepareStatement(query); // Insert query into Ps

        preparedStatement.setString(1, subtask.getName());
        preparedStatement.setString(2, subtask.getDescription());
        preparedStatement.setDouble(3, subtask.getEstimatedTime());
        preparedStatement.setInt(4, id);
        preparedStatement.executeUpdate();
    }

    public ArrayList<Subtask> getSubtasks(int id) throws SQLException {
        Connection connection = DBManager.getConnection();
        String query = "SELECT * FROM subtasks WHERE connected_task = ?";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        ArrayList<Subtask> subtaskList = new ArrayList<>();
        while (rs.next()) {
            Subtask subtask = new Subtask(rs.getInt("subtask_id"), rs.getString("subtask_name"), rs.getString("subtask_desc"), rs.getDouble("estimated_time"));
            subtaskList.add(subtask);
        }
        return subtaskList;
    }

    public ArrayList<Subtask> getAllSubtasks(int id) throws SQLException {
        Connection connection = DBManager.getConnection();
        String query = "SELECT subtask_name, estimated_time, connected_task FROM subtasks JOIN tasks ON subtasks.connected_task = tasks.task_id WHERE tasks.connected_project = ?";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        ArrayList<Subtask> subtaskList = new ArrayList<>();
        while (rs.next()) {
            Subtask subtask = new Subtask(rs.getString("subtask_name"), rs.getDouble("estimated_time"), rs.getInt("connected_task"));
            subtaskList.add(subtask);
        }
        return subtaskList;
    }

    public void deleteSubTask(int id) throws SQLException {

        Connection connection = DBManager.getConnection();
        String query = "DELETE FROM subtasks WHERE subtask_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1,id);

        ps.executeUpdate();
    }

}