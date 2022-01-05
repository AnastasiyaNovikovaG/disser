package novikava.repository;

import novikava.entity.LogbookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogbookRepository extends CrudRepository<LogbookEntity, Integer> {

    LogbookEntity findLogbookById(Integer id);
    //LogbookEntity findLogbookEntityByTeacherByIdTeach(Integer id);
    List<LogbookEntity> findAllByMonthsIdAndDepartmentId(Integer month, Integer department);
    List<LogbookEntity> findAllByMonthsId(Integer month);
    List<LogbookEntity> findAllByMonthsIdAndIdTeach(Integer month, Integer teacher);
    List<LogbookEntity> findAllByIdTeach(Integer id);
    //LogbookEntity findLogbookByTeacherId(Integer id);
    List<LogbookEntity> findAll();
    LogbookEntity save(LogbookEntity logbookEntity);
    void delete(LogbookEntity logbookEntity);
    void deleteById(Integer id);
    //void updateLogbookById(Integer id, LogbookEntity logbookEntity);

}
