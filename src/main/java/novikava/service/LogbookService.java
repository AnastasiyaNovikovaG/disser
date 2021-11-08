package novikava.service;

import novikava.entity.LogbookEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LogbookService {

    LogbookEntity findLogbookById(Integer id);
    List<LogbookEntity> findAll();
    LogbookEntity save(LogbookEntity logbookEntity);
    void delete(LogbookEntity logbookEntity);
    void deleteById(Integer id);
    void updateLogbookById(Integer id, LogbookEntity logbookEntity);

}
