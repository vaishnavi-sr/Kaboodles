package lift.off.project.models.data;


import lift.off.project.models.UserSignIn;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserSignInRepository extends CrudRepository<UserSignIn, Integer> {

}
