package lift.off.project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Pro  {

    public Pro(){

    }

    @Id
    @GeneratedValue
    @NotNull
    private int id;

    public int getId() {
        return id;
    }

    @NotNull
    private int registeredProID;
    //optional registration(Might Use Later)

    @NotNull
    private String homeServiceType;


    @NotNull
    private String location;


    public void setId(int id) {
        this.id = id;
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


    public Pro(int id, int registeredProID, String homeServiceType, String location) {
        this.id = id;
        this.registeredProID = registeredProID;
        this.homeServiceType = homeServiceType;
        this.location = location;
    }
}



