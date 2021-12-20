package models.dto;

import javax.validation.constraints.NotNull;

public class ProServiceDTO {

    @NotNull
    private int registeredProID;

    @NotNull
    private String homeServiceType;





    @NotNull
    private String location;

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
