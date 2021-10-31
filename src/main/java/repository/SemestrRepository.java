package repository;

import entity.SemestrEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SemestrRepository extends CrudRepository<SemestrEntity, Integer> {

    SemestrEntity findSemestrById(Integer id);
    List<SemestrEntity> findAll();
}
