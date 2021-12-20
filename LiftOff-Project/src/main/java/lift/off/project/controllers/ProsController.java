package lift.off.project.controllers;

import lift.off.project.models.Customer;
import lift.off.project.models.Pro;
import lift.off.project.models.data.CustomerRepository;
import models.dto.ProServiceDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/proService")
public class ProsController {

    @GetMapping("/create")
    public String displayRegistrationForm(Model model) {
        model.addAttribute("title", "ProServiceRegister");
        model.addAttribute("proServiceDTO",new ProServiceDTO());
        return "/proService/create";

    }

    @PostMapping("/add")
    public String processAddProLoginForm(@ModelAttribute @Valid Pro newPro,
                                         Errors errors, Model model, @RequestParam int customerId, @RequestParam List<Integer> customers){
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Pros");
//        model.addAttribute("title","Pro Login Page");
        return "add";
    }
        List<Customer> customerObjs = (List<Customer>) CustomerRepository.findAllById(customers);
        newPro.setCustomers(customerObjs);
        CustomerRepository.save(newPro.getCustomer());
        return "redirect:"






//
//    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
//                                    Errors errors, Model model, @RequestParam int employerId, @RequestParam List<Integer> skills) {
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Job");
//            return "add";
//        }
//
//        List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
//        newJob.setSkills(skillObjs);
//
//        Optional<Employer> optEmployer = employerRepository.findById(employerId);
//
//        if (optEmployer.isEmpty()) {
//            model.addAttribute("title", "Invalid Employer ID: " + employerId);
//        } else {
//            Employer event = optEmployer.get();
//            model.addAttribute("title", optEmployer.get() + " Details");
//            model.addAttribute("employer", optEmployer);
//        }
//
//        employerRepository.save(newJob.getEmployer());
//        return "redirect:";
//
//
//    }



}
