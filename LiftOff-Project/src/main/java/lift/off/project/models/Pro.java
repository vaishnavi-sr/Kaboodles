package lift.off.project.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pro extends AbstractEntity {

    @ManyToMany
//   @JoinTable(name = "pro_pro_skills",
//            joinColumns = @JoinColumn(name = "pro_id", referencedColumnName = "pro_skills_id"))
    private List<ProSkill> proSkills;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @ManyToMany
    private List<ProSkill> ProSkills = new ArrayList<>();

    @Override
    public String getUserName() {
        return null;
    }

    @NotNull
    private int registeredProID;
    //optional registration(Might Use Later)

    @NotNull
    private String homeServiceType;


    @NotNull
    private String location;

    public List<ProSkill> getProSkills() {
        return proSkills;
    }

    public void setProSkills(List<ProSkill> proSkills) {
        this.proSkills = proSkills;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Pro(){

    }




    public Pro(int id, int registeredProID, String homeServiceType, String location,List<ProSkill>someProSkills){
        this.registeredProID = registeredProID;
        this.homeServiceType = homeServiceType;
        this.location = location;
        this.ProSkills = someProSkills;
    }

}



