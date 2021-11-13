package novikava.repository;

import novikava.entity.PlanEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends CrudRepository<PlanEntity, Integer> {


    PlanEntity findPlanById(Integer id);
    PlanEntity findPlanByTeacherId(Integer id);
    List<PlanEntity> findAll();
    PlanEntity save(PlanEntity planEntity);
    void delete(PlanEntity planEntity);
    void deleteById(Integer id);
    //void updatePlanById(Integer id, PlanEntity planEntity);

}
