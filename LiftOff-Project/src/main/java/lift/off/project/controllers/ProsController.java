package lift.off.project.controllers;

import models.dto.ProServiceDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/proService")
public class ProsController {

    @GetMapping("/create")
    public String displayRegistrationForm(Model model) {
        model.addAttribute("title", "ProServiceRegister");
        model.addAttribute("proServiceDTO",new ProServiceDTO());
        return "/proService/create";
    }


}
