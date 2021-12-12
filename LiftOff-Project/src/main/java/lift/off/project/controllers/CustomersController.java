package lift.off.project.controllers;

import lift.off.project.models.Employer;
import lift.off.project.models.data.CustomersRepository;
import lift.off.project.models.data.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("customers")
public class CustomersController {

    @Autowired
    private CustomersRepository customersRepository;

    private Customers newCustomers;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("customers",customersRepository.findAll());
        return "customers/index";
    }

    @GetMapping("add")
    public String displayAddCustomersForm(@RequestParam(required = false) Integer customersId, Model model){

        model.addAttribute("Name","Customers");
        model.addAttribute(new Customers());
        model.addAttribute("categories",customersRepository.findAll());
    }

}

@Controller
@RequestMapping("employers")
public class EmployerController {


    @GetMapping("add")
    public String displayAddEmployerForm(@RequestParam(required = false) Integer employerId, Model model) {

        model.addAttribute("title", "Employers");
        model.addAttribute(new Employer());
        model.addAttribute("categories",employerRepository.findAll());
        return "employers/add";
    }


    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                         Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title","Add Employers");
            return "employers/add";
        }
        employerRepository.save(newEmployer);
        return "redirect:";
    }

    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {

        Optional optEmployer = employerRepository.findById(employerId);
        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employer", employer);
            return "employers/view";
        } else {
            return "redirect:../";
        }
    }
}
