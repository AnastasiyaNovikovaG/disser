package repository;

import entity.DepartmentEntity;
import entity.DepartmentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends CrudRepository<DepartmentEntity, Integer> {

    DepartmentEntity findDepartmentById(Integer id);
    List<DepartmentEntity> findAll();

}

