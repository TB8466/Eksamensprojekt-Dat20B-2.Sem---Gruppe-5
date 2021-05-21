package eksamensprojekt2semester.Controllers;

import eksamensprojekt2semester.DatabaseAccessLayer.SubTaskManager;
import eksamensprojekt2semester.Model.SubTask;
import eksamensprojekt2semester.Model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;
@Controller
public class SubtaskController {
SubTaskManager subTaskManager = new SubTaskManager();


    //displayer task
    @GetMapping("/create-subtask/{taskid}")
    public String rendertaskform(@PathVariable("taskid") int id, Model model) throws SQLException {
        model.addAttribute("id",id);
      //  model.addAttribute("taskList", subTaskManager.viewSubTasks(id));
        return "/subtask/create-subtask";
    }

    //Creator task
    @PostMapping("/addsubtask")
    public String createTask(WebRequest request) throws SQLException {

        String name = request.getParameter("subtaskname");
        String description = request.getParameter("subtaskdescription");
        int id = Integer.parseInt(request.getParameter("id"));
        double eta= Double.parseDouble(request.getParameter("estimatedTime"));
        SubTask subTask = new SubTask(name,description,eta);

        subTaskManager.createSubTask(subTask,id);

        return "/subtask/create-subtask";
    }

    @PostMapping("/getSubTasks")
    public String renderGetTasks(WebRequest request, Model model) throws SQLException {

        return "/subtask/create-subtask";



}


}
