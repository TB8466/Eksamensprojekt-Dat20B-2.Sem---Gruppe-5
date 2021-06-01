package eksamensprojekt2semester.Controllers;
import eksamensprojekt2semester.DatabaseAccessLayer.TaskManager;
import eksamensprojekt2semester.Model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;

@Controller
public class TaskController {
    private TaskManager taskManager = new TaskManager();

    //Displays tasks and the form for creation
    @GetMapping("/create-task/{id}")
    public String displayTaskForm(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("id",id);
        model.addAttribute("taskList", taskManager.getTasks(id));
        return "/task/create-task";
    }

    //Create a task
    @PostMapping("/addtask")
    public String createTask(WebRequest request) throws SQLException {

        String name = request.getParameter("taskname");
        String description = request.getParameter("taskdescription");
        int id = Integer.parseInt(request.getParameter("id"));
        Task task = new Task(name,description);

        taskManager.createTask(task,id);
        return "redirect:/create-task/"+id;
    }

    //Deletes a task and all connected subtasks
    @PostMapping("/delete-task")
    public String deleteTask(WebRequest request, int id) throws SQLException {
        String taskID = request.getParameter("taskid");
        taskManager.deleteTask(id);


        return "redirect:/create-task/" + taskID;
    }

}
