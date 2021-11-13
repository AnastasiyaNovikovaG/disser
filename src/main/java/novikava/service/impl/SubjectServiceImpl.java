package novikava.service.impl;

import novikava.entity.SubjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import novikava.repository.SubjectRepository;
import novikava.service.SubjectService;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public SubjectEntity findSubjectById(Integer id) {
        return subjectRepository.findSubjectById(id);
    }

    @Override
    public List<SubjectEntity> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public SubjectEntity save(SubjectEntity subjectEntity) {
        return subjectRepository.save(subjectEntity);
    }

    @Override
    public void delete(SubjectEntity subjectEntity) {
        subjectRepository.delete(subjectEntity);
    }

    @Override
    public void deleteById(Integer id) {
        subjectRepository.deleteById(id);
    }

    /*@Override
    public void updateSubjectById(Integer id, SubjectEntity subjectEntity) {
        subjectRepository.updateSubjectById(id,subjectEntity);
    }*/
}
