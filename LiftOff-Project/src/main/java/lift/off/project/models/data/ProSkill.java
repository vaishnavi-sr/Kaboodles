package lift.off.project.models.data;

import lift.off.project.models.AbstractEntity2;
import lift.off.project.models.HomeServices;


import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProSkill extends AbstractEntity2 {

    @ManyToMany(mappedBy = "proSkills")
    private List<HomeServices> homeServices = new ArrayList<HomeServices>();

    @NotBlank(message = "Description is required")
    @Size(max = 500 , message = "Description must be less than 500 characters")
    private String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProSkill() {}

    public List<HomeServices> getHomeServices() {
        return homeServices;
    }

    public void setHomeServices(List<HomeServices> homeServices) {
        this.homeServices = homeServices;
    }



}
