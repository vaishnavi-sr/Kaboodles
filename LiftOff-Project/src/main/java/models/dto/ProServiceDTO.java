package models.dto;

import javax.validation.constraints.NotNull;

public class ProServiceDTO {

    @NotNull
    private int registeredProID;

    @NotNull
    private String homeServiceType;

    @NotNull
    private String location;

    @NotNull
    private int costPerHour;

    @NotNull
    private String contactNumber;

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(int costPerHour) {
        this.costPerHour = costPerHour;
    }




    public int getRegisteredProID() {
        return registeredProID;
    }

    public void setRegisteredProID(int registeredProID) {
        this.registeredProID = registeredProID;
    }

    public String getHomeServiceType() {
        return homeServiceType;
    }

    public void setHomeServiceType(String homeServiceType) {
        this.homeServiceType = homeServiceType;
    }



    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
