package service.impl;

import entity.MonthsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MonthsRepository;
import service.MonthsService;

import java.util.List;

@Service
public class MonthsServiceImpl implements MonthsService {

    @Autowired
    private MonthsRepository monthsRepository;

    @Override
    public MonthsEntity findMonthById(Integer id) {
        return monthsRepository.findMonthById(id);
    }

    @Override
    public List<MonthsEntity> findAll() {
        return monthsRepository.findAll();
    }
}
