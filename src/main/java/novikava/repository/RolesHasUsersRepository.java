package novikava.repository;

import novikava.entity.RolesHasUsers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesHasUsersRepository extends CrudRepository<RolesHasUsers, Integer> {

    List<RolesHasUsers> findAll();
    RolesHasUsers save(RolesHasUsers rolesHasUsers);
   // void delete(RolesHasUsers rolesHasUsers);
   // void deleteByUsersByUsersEntityId (Integer id);

}
