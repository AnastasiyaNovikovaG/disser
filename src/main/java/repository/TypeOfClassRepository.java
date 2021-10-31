package repository;

import entity.TypeOfClassEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeOfClassRepository extends CrudRepository<TypeOfClassEntity, Integer> {

    TypeOfClassEntity findTypeOfClassById(Integer id);
    List<TypeOfClassEntity> findAll();
    TypeOfClassEntity save(TypeOfClassEntity typeOfClassEntity);
    void delete(TypeOfClassEntity typeOfClassEntity);
    void deleteById(Integer id);
    void updateTypeOfClassById(Integer id, TypeOfClassEntity typeOfClassEntity);

}
