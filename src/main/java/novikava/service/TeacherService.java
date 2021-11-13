package novikava.service;

import novikava.entity.TeacherEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

    TeacherEntity findTeacherById(Integer id);
    List<TeacherEntity> findAll();
    TeacherEntity save(TeacherEntity teacherEntity);
    void delete(TeacherEntity teacherEntity);
    void deleteById(Integer id);
    //void updateTeacherById(Integer id, TeacherEntity teacherEntity);

}
