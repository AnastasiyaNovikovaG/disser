package novikava.service.impl;

import novikava.entity.RolesHasUsers;
import novikava.repository.PlanRepository;
import novikava.repository.RolesHasUsersRepository;
import novikava.service.RolesHasUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesHasUsersServiceImpl implements RolesHasUsersService {

    @Autowired
    private RolesHasUsersRepository rolesHasUsersRepository;

    @Override
    public List<RolesHasUsers> findAll() {
        return rolesHasUsersRepository.findAll();
    }

    @Override
    public RolesHasUsers save(RolesHasUsers rolesHasUsers) {
        return rolesHasUsersRepository.save(rolesHasUsers);
    }

  /*  @Override
    public void delete(RolesHasUsers rolesHasUsers) {
        rolesHasUsersRepository.delete(rolesHasUsers);
    }*/

  /*  @Override
    public void deleteByUsersByUsersEntityId(Integer id) {
        rolesHasUsersRepository.deleteByUsersByUsersEntityId(id);
    }*/
}
