package lift.off.project.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HomeService extends AbstractEntity2 {

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    private List<ProSkill> proSkills = new ArrayList<>();


    public HomeService(){
    }

    public HomeService(Customer aCustomer, List<ProSkill> someSkills) {
        super();
        this.customer = aCustomer;
        this.proSkills = someSkills;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ProSkill> getProSkills() {
        return proSkills;
    }

    public void setProSkills(List<ProSkill> proSkills) {
        this.proSkills = proSkills;
    }
}