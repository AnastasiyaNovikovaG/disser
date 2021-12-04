package novikava.service.impl;

import novikava.entity.ERole;
import novikava.entity.RolesEntity;
import novikava.repository.RolesRepository;
import novikava.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesRepository rolesRepository;


    @Override
    public Optional<RolesEntity> findByRole(ERole role) {
        return rolesRepository.findByRole(role);
    }
}
