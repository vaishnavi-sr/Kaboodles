package lift.off.project.controllers;

import lift.off.project.models.data.JobRepository;
import lift.off.project.models.Job;
import lift.off.project.models.data.EmployerRepository;
import lift.off.project.models.JobData;
import lift.off.project.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping(value = "list")
public class ListController {
    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private JobRepository jobRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {

        columnChoices.put("all", "All");
        columnChoices.put("employer", "Employer");
        columnChoices.put("skill", "Skill");

    }

    @RequestMapping("")
    public String list(Model model) {
//        model.addAttribute("All","View All");
        model.addAttribute("employers",employerRepository.findAll());
        model.addAttribute("skills",skillRepository.findAll());
//        model.addAttribute("jobs",jobRepository.findAll());

        return "list";
    }

    @RequestMapping(value = "jobs")
    public String listJobsByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Job> jobs;
        if (column.toLowerCase().equals("all")){
            jobs = jobRepository.findAll();
            model.addAttribute("title", "All Jobs");
        } else {
            jobs = JobData.findByColumnAndValue(column, value, jobRepository.findAll());
            model.addAttribute("title", "Jobs with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("jobs", jobs);

        return "list-jobs";
    }
}