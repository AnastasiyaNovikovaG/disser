package novikava.service.impl;

import novikava.entity.AcademicDegreeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import novikava.repository.AcademicDegreeRepository;
import novikava.service.AcademicDegreeService;

import java.util.List;

@Service
public class AcademicDegreeServiceImpl implements AcademicDegreeService {
@Autowired
private AcademicDegreeRepository academicDegreeRepository;


    @Override
    public AcademicDegreeEntity findAcademicDegreeById(Integer id) {
        return academicDegreeRepository.findAcademicDegreeById(id);
    }

    @Override
    public List<AcademicDegreeEntity> findAll() {

        return academicDegreeRepository.findAll();
    }
}
