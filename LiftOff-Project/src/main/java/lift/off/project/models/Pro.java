package lift.off.project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Pro  {

    @Id
    @GeneratedValue
    @NotNull
    private int id;

    @NotNull
    private String homeServiceType;
    @NotNull
    private String location;

    @NotNull
    private int costPerHour;


    @NotNull
    private String contactNumber;

    public int getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(int costPerHour) {
        this.costPerHour = costPerHour;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }




    public Pro(int id, String homeServiceType, String location, int registeredProID) {
        this.id = id;
        this.homeServiceType = homeServiceType;
        this.location = location;
        this.registeredProID = registeredProID;
    }




    @NotNull
    private int registeredProID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getRegisteredProID() {
        return registeredProID;
    }

    public void setRegisteredProID(int registeredProID) {
        this.registeredProID = registeredProID;
    }


    public Pro(){

    }

}



