package novikava.service;

import novikava.entity.PlanEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlanService {

    PlanEntity findPlanById(Integer id);
    PlanEntity findPlanByTeacherId(Integer id);
    List<PlanEntity> findAll();
    PlanEntity save(PlanEntity planEntity);
    void delete(PlanEntity planEntity);
    void deleteById(Integer id);
    //void updatePlanById(Integer id, PlanEntity planEntity);

}
