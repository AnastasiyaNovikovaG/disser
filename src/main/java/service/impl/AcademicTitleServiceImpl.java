package service.impl;

import entity.AcademicDegreeEntity;
import entity.AcademicTitleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AcademicDegreeRepository;
import repository.AcademicTitleRepository;
import service.AcademicDegreeService;
import service.AcademicTitleService;

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
