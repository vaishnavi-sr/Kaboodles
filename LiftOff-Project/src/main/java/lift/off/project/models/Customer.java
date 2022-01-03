package lift.off.project.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Customer extends  AbstractEntity2 {

    @NotBlank(message = "First Name is required")
    @Size(max = 50, message = "Must be within 50 characters")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    @Size(max = 50, message = "Must be within 50 characters")
    private String lastName;

    @NotNull(message = "Email is required")
    @Size(max = 50, message = "Must be within 50 characters")
    private String email;

    @NotNull
    @Size(max=60)
    private String pwHash;

    @NotNull
    private String homeServiceType;


    @NotNull
    @Size(max=20)
    private String registeredType;

    @NotNull
    @Size(max=20)
    private String userName;




    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @NotNull
    private String location;


//    @ManyToMany
//    @JoinColumn(name = "customer_id")
//    private final List<HomeServices> homeServices = new ArrayList<>();

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Customer(String email, String password,String name, String firstName, String lastName,String registeredType) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pwHash = encoder.encode(password);
        this.registeredType=registeredType;
        super.setName(name);
    }

    public Customer() {}

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegisteredType() {
        return registeredType;
    }

    public void setRegisteredType(String registeredType) {
        this.registeredType = registeredType;
    }

    public String getHomeServiceType() {
        return homeServiceType;
    }

    public void setHomeServiceType(String homeServiceType) {
        this.homeServiceType = homeServiceType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

