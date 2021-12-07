package lift.off.project.controllers;

import lift.off.project.models.Skill;
import lift.off.project.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("skills")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    private Skill newSkill;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("skills",skillRepository.findAll());
        return "skills/index";
    }



    @GetMapping("add")
    public String displayAddSkillForm(@RequestParam(required = false) Integer skillId, Model model) {

        model.addAttribute("title", "Create Skill");
        model.addAttribute(new Skill());
        model.addAttribute("categories",skillRepository.findAll());
        return "skills/add";
    }


    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                   Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title","Add Skills");
            return "skills/add";
        }
        skillRepository.save(newSkill);
        return "redirect:";
    }

    @GetMapping("view/{skillId}")
    public String displayViewSkill(Model model, @PathVariable int skillId) {

        Optional<Skill> optSkill = skillRepository.findById(skillId);
        if (optSkill.isPresent()) {
            Skill skill = (Skill) optSkill.get();
            model.addAttribute("skill", skill);
            model.addAttribute("jobs",skill.getJobs());
            return "skills/view";
        } else {
            return "redirect:../";
        }
    }
}
