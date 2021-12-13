package lift.off.project.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class User extends AbstractEntity {
    @NotNull
    private  String username;

    @NotNull
    @Size(max=60)
    private String pwHash;



    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    public User(String username, String password,String name) {
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

}
