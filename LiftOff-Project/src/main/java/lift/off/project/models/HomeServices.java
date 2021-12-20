package lift.off.project.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HomeServices extends AbstractEntity {

    @ManyToMany(mappedBy = "homeServices")
    private List<Job> jobs = new ArrayList<Job>();

    @NotBlank(message = "Description is required")
    @Size(max = 500 , message = "Description must be less than 500 characters")
    private String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Skill() {}

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }


}