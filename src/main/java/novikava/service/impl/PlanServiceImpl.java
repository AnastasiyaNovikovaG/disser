package novikava.service.impl;

import novikava.entity.PlanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import novikava.repository.PlanRepository;
import novikava.service.PlanService;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Override
    public PlanEntity findPlanById(Integer id) {
        return planRepository.findPlanById(id);
    }

    @Override
    public PlanEntity findPlanByTeacherId(Integer id) {
        return planRepository.findPlanByTeacherId(id);
    }

    @Override
    public List<PlanEntity> findAll() {
        return planRepository.findAll();
    }

    @Override
    public PlanEntity save(PlanEntity planEntity) {
        return planRepository.save(planEntity);
    }

    @Override
    public void delete(PlanEntity planEntity) {
        planRepository.delete(planEntity);
    }

    @Override
    public void deleteById(Integer id) {
        planRepository.deleteById(id);
    }

    @Override
    public void updatePlanById(Integer id, PlanEntity planEntity) {
        planRepository.updatePlanById(id,planEntity);
    }
}
