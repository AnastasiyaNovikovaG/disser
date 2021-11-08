package novikava.service;

import novikava.entity.AcademicTitleEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AcademicTitleService {
    AcademicTitleEntity findAcademicTitleById(Integer id);

    List<AcademicTitleEntity> findAll();

}
