package novikava.service;

import novikava.entity.FacultyEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FacultyService {
    FacultyEntity findFacultyById(Integer id);

    List<FacultyEntity> findAll();

}
