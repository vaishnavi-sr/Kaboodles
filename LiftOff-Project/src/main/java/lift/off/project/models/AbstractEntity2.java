package lift.off.project.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntity2 {

        @Id
        @GeneratedValue
        @NotNull
        private int id;

        public int getId() {
            return id;
        }
    @NotBlank(message = "First Name is required")
    @Size(max = 50, message = "Must be within 50 characters")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    @Size(max = 50, message = "Must be within 50 characters")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Size(max = 50, message = "Must be within 50 characters")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(max = 50, message = "Must be within 50 characters")
    private String password;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity2)) return false;
        AbstractEntity2 that = (AbstractEntity2) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
