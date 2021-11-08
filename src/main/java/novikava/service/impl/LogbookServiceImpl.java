package novikava.service.impl;

import novikava.entity.LogbookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import novikava.repository.LogbookRepository;
import novikava.service.LogbookService;

import java.util.List;

@Service
public class LogbookServiceImpl implements LogbookService {

    @Autowired
    private LogbookRepository logbookRepository;

    @Override
    public LogbookEntity findLogbookById(Integer id) {
        return logbookRepository.findLogbookById(id);
    }

    @Override
    public List<LogbookEntity> findAll() {
        return logbookRepository.findAll();
    }

    @Override
    public LogbookEntity save(LogbookEntity logbookEntity) {
        return logbookRepository.save(logbookEntity);
    }

    @Override
    public void delete(LogbookEntity logbookEntity) {
        logbookRepository.delete(logbookEntity);
    }

    @Override
    public void deleteById(Integer id) {
        logbookRepository.deleteById(id);
    }

    @Override
    public void updateLogbookById(Integer id, LogbookEntity logbookEntity) {
        logbookRepository.updateLogbookById(id,logbookEntity);
    }
}
