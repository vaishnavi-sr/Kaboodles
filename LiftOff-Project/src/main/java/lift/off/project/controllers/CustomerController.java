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
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    private Customer newCustomer;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("customers",customerRepository.findAll());
        return "customers/index";
    }

    @GetMapping("add")
    public String displayAddCustomerForm(@RequestParam(required = false) Integer customerId, Model model){

        model.addAttribute("Name","Customers");
        model.addAttribute(new Customer());
        model.addAttribute("categories",customerRepository.findAll());
        return "customers/add";
    }

    @PostMapping("add")
    public String processAddCustomerForm(@ModelAttribute @Valid Customer newCustomer, Errors errors,
                                          Model model){

        if (errors.hasErrors()){
            model.addAttribute("title", "Add Customers");
            return "customers/add";
        }

        customerRepository.save(newCustomer);
        return "redirect:";
    }

    @GetMapping("view/{customerId}")
    public String displayViewCustomer(Model model, @PathVariable int customerId){

        Optional optCustomer = customerRepository.findById(customerId);
        if (optCustomer.isPresent()){
            Employer employer = (Employer) optCustomer.get();
            model.addAttribute("customer", customer);
            return "customers/view";
        } else {
            return "redirect:../";
        }
    }
}
