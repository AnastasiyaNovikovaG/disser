package novikava.service;

import novikava.entity.UsersEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    UsersEntity findByEmail(String email);
    UsersEntity findUserById(Integer id);
   // UsersEntity findByUsername(String username);
    List<UsersEntity> findAll();
    Boolean existsByEmail(String email);
    UsersEntity save(UsersEntity usersEntity);
    void delete(UsersEntity usersEntity);
    void deleteById(Integer id);
}
