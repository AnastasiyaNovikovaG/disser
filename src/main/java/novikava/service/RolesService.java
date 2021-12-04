package novikava.service;

import novikava.entity.ERole;
import novikava.entity.RolesEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RolesService {

    Optional<RolesEntity> findByRole(ERole role);
}
