package lift.off.project.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pro extends AbstractEntity2 {

//    @Id
//    @GeneratedValue
//    @NotNull
//    private int id;
//
//    public int getId() {
//        return id;
//    }
//
//    @NotBlank(message = "First Name is required")
//    @Size(max = 50, message = "Must be within 50 characters")
//    private String firstName;
//
//    @NotBlank(message = "Last Name is required")
//    @Size(max = 50, message = "Must be within 50 characters")
//    private String lastName;
//
//    @NotBlank(message = "Email is required")
//    @Size(max = 50, message = "Must be within 50 characters")
//    private String email;
//
//    @NotBlank(message = "Password is required")
//    @Size(max = 50, message = "Must be within 50 characters")
//    private String password;

    @OneToMany
    @JoinColumn
    private final List<HomeServices> homeServices = new ArrayList<>();


//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setL
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }astName(String lastName) {
//        this.lastName = lastName;
//    }
//

    public Pro() {}


}



