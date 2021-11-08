package novikava.service;

import novikava.entity.MonthsEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MonthsService {

    MonthsEntity findMonthById(Integer id);
    List<MonthsEntity> findAll();

}
