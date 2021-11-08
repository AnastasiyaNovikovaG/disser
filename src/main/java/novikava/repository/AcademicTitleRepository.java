package novikava.repository;

import novikava.entity.AcademicTitleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademicTitleRepository extends CrudRepository<AcademicTitleEntity, Integer> {

    AcademicTitleEntity findAcademicTitleById(Integer id);

    List<AcademicTitleEntity> findAll();
}
