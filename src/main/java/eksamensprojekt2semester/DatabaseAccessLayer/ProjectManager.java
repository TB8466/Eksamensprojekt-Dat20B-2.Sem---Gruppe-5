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
        String query = "INSERT INTO PROJECTS (PROJECT_NAME, PROJECT_DESC) VALUES(?,?)"; //SQL query
        PreparedStatement preparedStatement = connection.prepareStatement(query); // Insert query into Ps

        preparedStatement.setString(1, project.getName());
        preparedStatement.setString(2, project.getDescription());

        preparedStatement.executeUpdate();
    }



    //Receives data from mySQL and insert the data into an ArrayList
    public ArrayList<Project> viewProjects() throws SQLException {

        Connection connection = DBManager.getConnection();
        String query = "SELECT * from projects";
        PreparedStatement ps = connection.prepareStatement(query);


        ResultSet rs = ps.executeQuery();


        ArrayList<Project> projectList = new ArrayList<>();
        while(rs.next()){
            Project p1 = new Project(rs.getInt("project_id"),rs.getString("project_name"),rs.getString("project_desc"));
            projectList.add(p1);
        }
        //Return the list, so it can be transferred to view
        return projectList;
    }
}