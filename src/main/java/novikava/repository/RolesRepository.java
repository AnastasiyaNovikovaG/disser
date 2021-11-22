package novikava.repository;

import novikava.entity.ERole;
import novikava.entity.RolesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepository extends CrudRepository<RolesEntity,Integer> {

    Optional<RolesEntity> findByRole(ERole role);
}
