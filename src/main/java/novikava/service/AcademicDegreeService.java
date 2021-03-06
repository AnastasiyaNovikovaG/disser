package novikava.service;

import novikava.entity.AcademicDegreeEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AcademicDegreeService {

    AcademicDegreeEntity findAcademicDegreeById(Integer id);

    List<AcademicDegreeEntity> findAll();
}
