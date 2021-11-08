package novikava.service.impl;

import novikava.entity.SemestrEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import novikava.repository.SemestrRepository;
import novikava.service.SemestrService;

import java.util.List;

@Service
public class SemestrServiceImpl implements SemestrService {

    @Autowired
    private SemestrRepository semestrRepository;

    @Override
    public SemestrEntity findSemestrById(Integer id) {
        return semestrRepository.findSemestrById(id);
    }

    @Override
    public List<SemestrEntity> findAll() {
        return semestrRepository.findAll();
    }
}
