package models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ViewCustomerDTO {

    private String FirstName;
    private String lastName;
    private String serviceName;
    private String location;

    public String getRegisteredType() {
        return registeredType;
    }

    public void setRegisteredType(String registeredType) {
        this.registeredType = registeredType;
    }

    @NotNull
    @Size(max=20)
    private String registeredType;


    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
