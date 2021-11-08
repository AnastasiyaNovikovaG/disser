package novikava.service;

import novikava.entity.SubjectEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {

    SubjectEntity findSubjectById(Integer id);
    List<SubjectEntity> findAll();
    SubjectEntity save(SubjectEntity subjectEntity);
    void delete(SubjectEntity subjectEntity);
    void deleteById(Integer id);
    void updateSubjectById(Integer id, SubjectEntity subjectEntity);

}
