package repository;

import entity.AcademicDegreeEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface AcademicDegreeRepository extends CrudRepository<AcademicDegreeEntity, Integer> {

    AcademicDegreeEntity findAcademicDegreeById(Integer id);

    List<AcademicDegreeEntity> findAll();
}
