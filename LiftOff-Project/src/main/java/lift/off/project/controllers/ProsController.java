package lift.off.project.controllers;

import lift.off.project.models.Pro;
import lift.off.project.models.User;
import lift.off.project.models.data.ProRepository;
import lift.off.project.models.data.UserRepository;
import models.dto.ProServiceDTO;
import models.dto.ViewProDTO;
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

@Controller
@RequestMapping("/proService")
public class ProsController {
    private static final String userSessionKey = "user";

    @Autowired
    ProRepository proRepository;

    @Autowired
    UserRepository userRepository;

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
                   pro.getLocation();
                   pro.getHomeServiceType();
                   viewProDTO.setFirstName(user.getFirstName());
                   viewProDTO.setLastName(user.getLastName());
                   viewProDTOList.add(viewProDTO);
               }
            }

        }
       // List<User> proUsers = user.stream().filter("pro").collect(Collectors.toList());
        model.addAttribute("viewProDTO",viewProDTOList);
        model.addAttribute("title", "ProServiceRegister");

        return "/proService/view";

    }


    @GetMapping("/create")
    public String displayRegistrationForm(Model model) {
        model.addAttribute("title", "ProServiceRegister");
        model.addAttribute("proServiceDTO", new ProServiceDTO());
        return "/proService/create";

    }

    @PostMapping("/saveProService")
    public String saveProService(@ModelAttribute @Valid ProServiceDTO proServiceDTO,
                                          Errors errors, HttpServletRequest request,
                                          Model model) {

        int userId = (int) request.getSession().getAttribute(userSessionKey);
        proServiceDTO.setRegisteredProID(userId);
        return "";

    }



}
