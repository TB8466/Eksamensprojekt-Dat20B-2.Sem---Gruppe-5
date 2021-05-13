package eksamensprojekt2semester.DatabaseAccessLayer;

import eksamensprojekt2semester.Model.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProjectManager {

    //Creation of project
    public void createProject(Project project) throws SQLException {
        Connection connection = DBManager.getConnection();
        String query = "INSERT INTO PROJECTS (PROJECT_NAME, PROJECT_DESC) VALUES(?,?)"; //prepare query
        PreparedStatement preparedStatement = connection.prepareStatement(query); // tager imod query

        preparedStatement.setString(1, project.getName());
        preparedStatement.setString(2, project.getDescription());

        preparedStatement.executeUpdate();

    }
}
