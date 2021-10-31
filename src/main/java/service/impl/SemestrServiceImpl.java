package service.impl;

import entity.SemestrEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SemestrRepository;
import service.SemestrService;

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
