package repository;

import entity.SubjectEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends CrudRepository<SubjectEntity, Integer> {

    SubjectEntity findSubjectById(Integer id);
    List<SubjectEntity> findAll();
    SubjectEntity save(SubjectEntity subjectEntity);
    void delete(SubjectEntity subjectEntity);
    void deleteById(Integer id);
    void updateSubjectById(Integer id, SubjectEntity subjectEntity);

}
