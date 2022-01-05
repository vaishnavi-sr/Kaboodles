package lift.off.project.controllers;

import lift.off.project.models.Customer;
import lift.off.project.models.Pro;
import lift.off.project.models.ProSkill;
import lift.off.project.models.User;
import lift.off.project.models.data.CustomerRepository;
import lift.off.project.models.data.ProRepository;
import lift.off.project.models.data.ProSkillRepository;
import lift.off.project.models.data.UserRepository;
import models.dto.ProServiceDTO;
import models.dto.ViewProDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/proService")
public class ProsController {
    private static final String userSessionKey = "user";

    @Autowired
    ProRepository proRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProSkillRepository proSkillRepository;


    @GetMapping("/view")
    public String viewProDetails(Model model) {
        List<User> users = (List<User>) userRepository.findAll();
        List<User> userPros = new ArrayList<>();
        //Iterate user and write if condtion pro and add to new list object
        for(User user:users){
            if(user.getRegisteredType().equals("pro")){
                userPros.add(user);
            }
        }
        List<ViewProDTO> viewProDTOList = new ArrayList<>();

        //All Pro Data
        List<Pro> proList = (List<Pro>) proRepository.findAll();
        for(User user:userPros) {
            for(Pro pro:proList){
                if(pro.getRegisteredProID()== user.getId()){
                    ViewProDTO viewProDTO = new ViewProDTO();
//                    viewProDTO.setServiceName(pro.getHomeServiceType());
//                    viewProDTO.setFirstName(user.getFirstName());
//                    viewProDTO.setLastName(user.getLastName());
                    viewProDTO.setLocation(pro.getLocation());
                    viewProDTOList.add(viewProDTO);
                }
            }

        }
        // List<User> proUsers = user.stream().filter("pro").collect(Collectors.toList());
        System.out.println("view pro dto list size is +++============ "+viewProDTOList);
        model.addAttribute("viewProDTO",viewProDTOList);
        model.addAttribute("title", "List Of Services");

        return "/proService/view";

    }


    @GetMapping("/create")
    public String displayRegistrationForm(Model model) {
        model.addAttribute("title", "ProServiceRegister");
        model.addAttribute("proServiceDTO", new ProServiceDTO());

        return "/proService/create";

    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Pro newPro,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create ProService");
            return "proService/create";
        }

        proRepository.save(newPro);
        return "/proService/view";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Pro");
        model.addAttribute(new Pro());
        model.addAttribute("customers",customerRepository.findAll());
        model.addAttribute("proSkills",proSkillRepository.findAll());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Pro newPro,
                                    Errors errors, Model model, @RequestParam int customerId, @RequestParam List<Integer> proSkills) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Pro");
            return "add";
        }

        List<ProSkill> proSkillObjs = (List<ProSkill>) proSkillRepository.findAllById(proSkills);
        newPro.setProSkills(proSkillObjs);

        Optional<Customer> optCustomer = customerRepository.findById(customerId);

        if (optCustomer.isEmpty()) {
            model.addAttribute("title", "Invalid Customer ID: " + customerId);
        } else {
            Customer event = optCustomer.get();
            model.addAttribute("title", optCustomer.get() + " Details");
            model.addAttribute("customer", optCustomer);
        }

        customerRepository.save(newPro.getCustomer());
        return "redirect:";


    }




}