package novikava.repository;

import novikava.entity.MonthsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonthsRepository extends CrudRepository<MonthsEntity, Integer> {

    MonthsEntity findMonthById(Integer id);
    List<MonthsEntity> findAll();
}
