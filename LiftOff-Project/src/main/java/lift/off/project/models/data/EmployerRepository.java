package lift.off.project.models.data;

import lift.off.project.models.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends CrudRepository <Employer,Integer> {

}
