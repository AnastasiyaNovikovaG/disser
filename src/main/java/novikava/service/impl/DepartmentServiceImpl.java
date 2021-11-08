package novikava.service.impl;

import novikava.entity.DepartmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import novikava.repository.DepartmentRepository;
import novikava.service.DepartmentService;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

  @Autowired
  private DepartmentRepository departmentRepository;

    @Override
    public DepartmentEntity findDepartmentById(Integer id) {
        return departmentRepository.findDepartmentById(id);
    }

    @Override
    public List<DepartmentEntity> findAll() {
        return departmentRepository.findAll();
    }
}
