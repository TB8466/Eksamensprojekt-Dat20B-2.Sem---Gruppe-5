package eksamensprojekt2semester.Controllers;

import eksamensprojekt2semester.DatabaseAccessLayer.SubtaskManager;
import eksamensprojekt2semester.Model.Subtask;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;
@Controller
public class SubtaskController {
    private SubtaskManager subtaskManager = new SubtaskManager();


    //Displays subtasks and the form for creation
    @GetMapping("/create-subtask/{taskid}")
    public String renderSubtaskform(@PathVariable("taskid") int id, Model model) throws SQLException {
        model.addAttribute("id",id);
        model.addAttribute("subtaskList", subtaskManager.getSubtasks(id));
        return "/subtask/create-subtask";
    }

    //Create a subtask
    @PostMapping("/addsubtask")
    public String createSubtask(WebRequest request) throws SQLException {

        String name = request.getParameter("subtaskname");
        String description = request.getParameter("subtaskdescription");
        int id = Integer.parseInt(request.getParameter("id"));
        double eta= Double.parseDouble(request.getParameter("estimatedTime"));
        Subtask subtask = new Subtask(name,description,eta);

        subtaskManager.createSubtask(subtask,id);
        return "redirect:/create-subtask/"+id;
    }

    //Deletes a subtask
    @PostMapping("/delete-subtask")
    public String deleteSubtask(WebRequest request, int id) throws SQLException {
        String subtaskID = request.getParameter("subtaskid");
        subtaskManager.deleteSubtask(id);

        return "redirect:/create-subtask/" + subtaskID;
    }
}