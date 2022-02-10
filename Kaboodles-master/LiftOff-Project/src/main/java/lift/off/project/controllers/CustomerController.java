package lift.off.project.controllers;

import lift.off.project.models.Customer;
import lift.off.project.models.User;
import lift.off.project.models.data.CustomerRepository;
import lift.off.project.models.data.UserRepository;
import models.dto.RegisterFormDTO;
import models.dto.ViewCustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("customers")
public class CustomerController {

    private static final String userSessionKey = "user";

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    UserRepository userRepository;

//    @Autowired
//    HomeServiceRepository homeServiceRepository;

    private Customer newCustomer;

    @GetMapping("")
    public String index(Model model, HttpServletRequest request){
        int userId = (int) request.getSession().getAttribute("user");
        Optional<User> user = userRepository.findById(userId);
        //If we want to use model, we can use user
       // model.addAttribute("user",user);
        //If we want to use DTO, we need to create RegisterFormDTO object and set the data
        RegisterFormDTO registerFormDTO = new RegisterFormDTO();
        registerFormDTO.setFirstName(user.get().getFirstName());
        model.addAttribute("registerFormDTO",registerFormDTO);
        return "customers/index";
    }

    @GetMapping("viewServices")
    public String displayAddCustomerForm(Model model){


        model.addAttribute("Name","Customers");
        model.addAttribute(new Customer());
        model.addAttribute("customer",customerRepository.findAll());
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

    @GetMapping("view")
    public String displayViewJob(Model model) {
        List<User> users = (List<User>) userRepository.findAll();
        List<User> userCustomers = new ArrayList<>();
        //Iterate user and write if condtion pro and add to new list object
        for(User user:users){
            if(user.getRegisteredType().equals("customer")){
                userCustomers.add(user);
            }
        }
        List<ViewCustomerDTO> viewCustomerDTOList = new ArrayList<>();
        for(User userCustomer:userCustomers){
            ViewCustomerDTO viewCustomerDTO = new ViewCustomerDTO();
            viewCustomerDTO.setFirstName(userCustomer.getFirstName());
            viewCustomerDTO.setLastName(userCustomer.getLastName());
            viewCustomerDTO.setUsername(userCustomer.getUsername());
            viewCustomerDTOList.add(viewCustomerDTO);

        }
        model.addAttribute("customers",viewCustomerDTOList);

        return "customers/view";
    }


    }




