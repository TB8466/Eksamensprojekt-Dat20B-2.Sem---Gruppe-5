package eksamensprojekt2semester.Controllers;

import eksamensprojekt2semester.DatabaseAccessLayer.ProjectManager;
import eksamensprojekt2semester.DatabaseAccessLayer.TaskManager;
import eksamensprojekt2semester.Model.Project;
import eksamensprojekt2semester.Model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;

@Controller
public class ProjectController {

    private ProjectManager projectManager = new ProjectManager();
    TaskManager taskManager = new TaskManager();

    //Arrival page
    @GetMapping("/")
    public String renderHome(){

        return "home";
    }

    //View all projects
    @PostMapping("/getProjects")
    public String renderGetProjects(Model model) throws SQLException {

        model.addAttribute("projectList",projectManager.viewProjects());

        return "get-projects";
    }

   @GetMapping("/project/{id}")
    public String getSpecificProject(@PathVariable("id") int id){
        return "project";
   }

    @GetMapping("/create-task/{id}")
    public String rendertaskform(@PathVariable("id")int id, Model model) {
        model.addAttribute(id);
        return "create-task";
    }

    @PostMapping("/addtask")
    public String createTask(WebRequest request) throws SQLException{
        String name = request.getParameter("taskname");
        String description = request.getParameter("taskdescription");
        int id = request.get
        Task task = new Task(name,description);

        taskManager.createTask(task,id);

        return "create-task";
    }




    //Project creation page
    @PostMapping("/projectCreator")
    public String displayProjectForm(){ return "create-project"; }

    //Receives data from HTML form via WebRequest, saves data as a Project-object and inserts Project-object into database
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