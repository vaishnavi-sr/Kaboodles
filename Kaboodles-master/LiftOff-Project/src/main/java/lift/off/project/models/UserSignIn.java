package lift.off.project.models;

import org.apache.catalina.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserSignIn extends AbstractEntity {

    @NotBlank(message = "Email is required")
    @Size(max = 50, message = "Must be within 50 characters")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(max = 50, message = "Must be within 50 characters")
    private String password;


    public UserSignIn(){}

    @Override
    public String getUserName() {
        return null;
    }
}
