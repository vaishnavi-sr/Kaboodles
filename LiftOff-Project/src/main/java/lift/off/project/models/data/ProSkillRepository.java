package lift.off.project.models.data;

import lift.off.project.models.ProSkill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProSkillRepository extends CrudRepository<ProSkill,Integer> {
}
