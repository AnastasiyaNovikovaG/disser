package novikava.repository;

import novikava.entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<UsersEntity, Integer> {


    UsersEntity findByEmail(String email);
    List<UsersEntity> findAll();
    Boolean existsByEmail(String email);
}
