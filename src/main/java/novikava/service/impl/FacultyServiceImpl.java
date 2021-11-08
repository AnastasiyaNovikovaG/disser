package novikava.service.impl;

import novikava.entity.FacultyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import novikava.repository.FacultyRepository;
import novikava.service.FacultyService;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;


    @Override
    public FacultyEntity findFacultyById(Integer id) {
        return facultyRepository.findFacultyById(id);
    }

    @Override
    public List<FacultyEntity> findAll() {
        return facultyRepository.findAll();
    }
}
