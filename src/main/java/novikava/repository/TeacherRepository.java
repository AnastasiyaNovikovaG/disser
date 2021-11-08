package novikava.repository;

import novikava.entity.TeacherEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends CrudRepository<TeacherEntity, Integer> {

    TeacherEntity findTeacherById(Integer id);
    List<TeacherEntity> findAll();
    TeacherEntity save(TeacherEntity teacherEntity);
    void delete(TeacherEntity teacherEntity);
    void deleteById(Integer id);
    void updateTeacherById(Integer id, TeacherEntity teacherEntity);

}

