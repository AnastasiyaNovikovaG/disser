package repository;

import entity.AcademicDegree;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface AcademicDegreeRepository extends CrudRepository<AcademicDegree, Integer> {

    AcademicDegree findAcademicDegreeById(Integer integer);

    List<AcademicDegree> findAll();
}
