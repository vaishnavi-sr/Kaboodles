package lift.off.project.models.data;

import lift.off.project.models.Pro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProRepository extends CrudRepository<Pro, Integer>{

}
