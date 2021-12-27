package lift.off.project.models.data;

import lift.off.project.models.HomeService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeServiceRepository extends CrudRepository<HomeService,Integer> {
}
