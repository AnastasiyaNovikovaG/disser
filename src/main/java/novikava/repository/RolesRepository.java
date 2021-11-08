package novikava.repository;

import novikava.entity.RolesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends CrudRepository<RolesEntity,Integer> {
    RolesEntity findByRole(String role);
}