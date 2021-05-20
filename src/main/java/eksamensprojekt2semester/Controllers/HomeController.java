package eksamensprojekt2semester.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    //Arrival page
    @GetMapping("/")
    public String renderHome(){
        return "home";
    }

    // fjern hvis vi har lavet "logo back to home"
    @PostMapping("/backToHome")
    public String renderBackToHome(){return "home";}
}
