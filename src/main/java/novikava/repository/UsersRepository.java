package novikava.repository;

import novikava.entity.TeacherEntity;
import novikava.entity.TypeOfClassEntity;
import novikava.entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<UsersEntity, Integer> {

    UsersEntity findByEmail(String email);
    UsersEntity findUsersById(Integer id);
//    Optional<UsersEntity> findByUsername(String username);
    List<UsersEntity> findAll();
    Boolean existsByEmail(String email);
    UsersEntity save(UsersEntity usersEntity);
    void delete(UsersEntity usersEntity);
    void deleteById(Integer id);
}

