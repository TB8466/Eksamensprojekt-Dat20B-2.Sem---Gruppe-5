package eksamensprojekt2semester.DatabaseAccessLayer;

import eksamensprojekt2semester.Model.Project;
import eksamensprojekt2semester.Model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProjectManager {

    //Creation of project
    public void createProject(Project project) throws SQLException {
        Connection connection = DBManager.getConnection();
        String query = "INSERT INTO projects (PROJECT_NAME, PROJECT_DESC) VALUES(?,?)"; //SQL query
        PreparedStatement preparedStatement = connection.prepareStatement(query); // Insert query into Ps

        preparedStatement.setString(1, project.getName());
        preparedStatement.setString(2, project.getDescription());

        preparedStatement.executeUpdate();
    }


    //Receives data from mySQL and insert the data into an ArrayList
    public ArrayList<Project> getProjects() throws SQLException {
        System.out.println("LOOK FOR THIS");
        Connection connection = DBManager.getConnection();
        String query = "SELECT * from projects";
        PreparedStatement ps = connection.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        ArrayList<Project> projectList = new ArrayList<>();
        while(rs.next()){
            Project p1 = new Project(rs.getInt("project_id"),rs.getString("project_name"),rs.getString("project_desc"), estimatedTime(rs.getInt("project_id")));
            projectList.add(p1);
        }
        //Return the list, so it can be transferred to view
        return projectList;
    }

    public String getSpecificProject(int id) throws SQLException {
        String name;
        Connection connection = DBManager.getConnection();
        String query = "SELECT project_name from projects WHERE project_id=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1,id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        name = rs.getString(1);
        return name;
    }

    public double estimatedTime(int id) throws SQLException {
        double estimatedTime = 0;

        Connection connection = DBManager.getConnection();
        String query = "SELECT sum(estimated_time) FROM subtasks JOIN tasks ON subtasks.connected_task = tasks.task_id  WHERE tasks.connected_project = ?";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        rs.next();
        estimatedTime = estimatedTime + rs.getDouble(1);

        return estimatedTime;
    }
    public void deleteProject(int id) throws SQLException {
        Connection connection = DBManager.getConnection();
        String query = "DELETE FROM projects WHERE project_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, id);
        ps.executeUpdate();
    }

}