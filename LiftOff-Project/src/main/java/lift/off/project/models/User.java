package lift.off.project.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class User extends AbstractEntity {

    @NotBlank(message = "First Name is required")
    @Size(max = 50, message = "Must be within 50 characters")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    @Size(max = 50, message = "Must be within 50 characters")
    private String lastName;

    @NotNull
    private  String username;

    @NotNull
    @Size(max=60)
    private String pwHash;




    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    public User(String username, String password,String name, String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.pwHash = encoder.encode(password);
        super.setName(name);
    }

    public User(){}

    public String getUsername() {
        return username;
    }

    public Boolean isMatchingPassword(String password){
        return encoder.matches(password,pwHash);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
