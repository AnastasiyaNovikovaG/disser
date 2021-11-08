package novikava.service.impl;

import novikava.entity.TeacherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import novikava.repository.TeacherRepository;
import novikava.service.TeacherService;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public TeacherEntity findTeacherById(Integer id) {
        return teacherRepository.findTeacherById(id);
    }

    @Override
    public List<TeacherEntity> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public TeacherEntity save(TeacherEntity teacherEntity) {
        return teacherRepository.save(teacherEntity);
    }

    @Override
    public void delete(TeacherEntity teacherEntity) {
        teacherRepository.delete(teacherEntity);
    }

    @Override
    public void deleteById(Integer id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public void updateTeacherById(Integer id, TeacherEntity teacherEntity) {
        teacherRepository.updateTeacherById(id,teacherEntity);
    }
}
