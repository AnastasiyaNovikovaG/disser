package service;

import entity.SemestrEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SemestrService {

    SemestrEntity findSemestrById(Integer id);
    List<SemestrEntity> findAll();

}
