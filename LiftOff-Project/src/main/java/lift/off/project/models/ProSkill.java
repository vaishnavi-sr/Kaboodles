package lift.off.project.models;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class ProSkill extends AbstractEntity {

   // @ManyToMany(mappedBy = "proSkills")
    private List<Pro> pros = new ArrayList<Pro>();

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

    @Override
    public String getUserName() {
        return null;
    }
}
