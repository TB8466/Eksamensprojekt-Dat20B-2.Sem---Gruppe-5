package eksamensprojekt2semester.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    //Arrival page
    //For more see templates/home.html
    @GetMapping("/")
    public String renderHome(){
        return "home";
    }

}
