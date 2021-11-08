package novikava.repository;

import novikava.entity.FacultyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends CrudRepository<FacultyEntity, Integer> {

    FacultyEntity findFacultyById(Integer id);
    List<FacultyEntity> findAll();

}
