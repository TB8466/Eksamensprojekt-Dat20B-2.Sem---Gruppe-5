package eksamensprojekt2semester.Controllers;

import eksamensprojekt2semester.DatabaseAccessLayer.ProjectManager;
import eksamensprojekt2semester.Model.Project;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;

@Controller
public class ProjectController {

    private ProjectManager projectManager = new ProjectManager();

    @GetMapping("/")
    public String renderHome(){
        return "home";
    }

    @PostMapping("/getProjects")
    public String renderGetProjects(){ return "get-projects"; }

    @PostMapping("/projectCreator")
    public String displayProjectForm(){ return "create-project"; }


    //Request kan trække data ud af HTML form
    @PostMapping("/createproject")
    public String createProject(WebRequest request) throws SQLException {
        String name = request.getParameter("projectname");
        String description = request.getParameter("projectdescription");

        Project project = new Project(name, description);

        projectManager.createProject(project);

        return "home";
    }

    // fjern hvis vi har lavet "logo back to home"
    @PostMapping("/backToHome")
    public String renderBackToHome(){return "Home";}
}