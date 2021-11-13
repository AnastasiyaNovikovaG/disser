package novikava.service;

import novikava.entity.TypeOfClassEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeOfClassService {

    TypeOfClassEntity findTypeOfClassById(Integer id);
    List<TypeOfClassEntity> findAll();
    TypeOfClassEntity save(TypeOfClassEntity typeOfClassEntity);
    void delete(TypeOfClassEntity typeOfClassEntity);
    void deleteById(Integer id);
    //void updateTypeOfClassById(Integer id, TypeOfClassEntity typeOfClassEntity);

}
