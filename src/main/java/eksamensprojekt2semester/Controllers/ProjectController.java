package eksamensprojekt2semester.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProjectController {

    @GetMapping("/")
    public String renderHome(){
        return "home";
    }

    @PostMapping("/getProjects")
    public String renderGetProjects(){ return "getProjects"; }

    @PostMapping("/createProjects")
    public String renderCreateProjects(){ return "createProjects"; }
// fjern hvis vi har lavet "logo back to home"
    @PostMapping("/backToHome")
    public String renderBackToHome(){return "Home";}
}
