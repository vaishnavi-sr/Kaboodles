package models.dto;

public class RegisterFormDTO extends LoginFormDTO {

    private String firstName;

    private String lastName;

    private String verifyPassword;

    public RegisterFormDTO() {

    }

    public String getVerifyPassword() {
        return verifyPassword;
    }



    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
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
