package novikava.service.impl;

import novikava.entity.TypeOfClassEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import novikava.repository.TypeOfClassRepository;
import novikava.service.TypeOfClassService;

import java.util.List;

@Service
public class TypeOfClassServiceImpl implements TypeOfClassService {

    @Autowired
    private TypeOfClassRepository typeOfClassRepository;

    @Override
    public TypeOfClassEntity findTypeOfClassById(Integer id) {
        return typeOfClassRepository.findTypeOfClassById(id);
    }

    @Override
    public List<TypeOfClassEntity> findAll() {
        return typeOfClassRepository.findAll();
    }

    @Override
    public TypeOfClassEntity save(TypeOfClassEntity typeOfClassEntity) {
        return typeOfClassRepository.save(typeOfClassEntity);
    }

    @Override
    public void delete(TypeOfClassEntity typeOfClassEntity) {
        typeOfClassRepository.delete(typeOfClassEntity);
    }

    @Override
    public void deleteById(Integer id) {
        typeOfClassRepository.deleteById(id);
    }

    /*@Override
    public void updateTypeOfClassById(Integer id, TypeOfClassEntity typeOfClassEntity) {
        typeOfClassRepository.updateTypeOfClassById(id,typeOfClassEntity);
    }*/
}
