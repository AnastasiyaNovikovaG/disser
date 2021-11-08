package novikava.service;

import novikava.entity.DepartmentEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    DepartmentEntity findDepartmentById(Integer id);
    List<DepartmentEntity> findAll();

}
