package lift.off.project.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class HomeServices extends AbstractEntity {



    @NotBlank(message = "Description is required")
    @Size(max = 500 , message = "Description must be less than 500 characters")
    private String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }







}