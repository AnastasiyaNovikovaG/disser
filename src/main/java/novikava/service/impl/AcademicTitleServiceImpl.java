package novikava.service.impl;

import novikava.entity.AcademicTitleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import novikava.repository.AcademicTitleRepository;
import novikava.service.AcademicTitleService;

import java.util.List;

@Service
public class AcademicTitleServiceImpl implements AcademicTitleService {
@Autowired
private AcademicTitleRepository academicTitleRepository;


    @Override
    public AcademicTitleEntity findAcademicTitleById(Integer id) {
        return academicTitleRepository.findAcademicTitleById(id);
    }

    @Override
    public List<AcademicTitleEntity> findAll() {
        return academicTitleRepository.findAll();
    }
}
