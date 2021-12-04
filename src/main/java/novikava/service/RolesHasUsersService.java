package novikava.service;

import novikava.entity.RolesHasUsers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RolesHasUsersService {

    List<RolesHasUsers> findAll();
    RolesHasUsers save(RolesHasUsers rolesHasUsers);
   /* void delete(RolesHasUsers rolesHasUsers);
    void deleteByUsersByUsersEntityId (Integer id);*/
}
