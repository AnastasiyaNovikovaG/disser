package novikava.service;

import novikava.entity.ContractEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContractService {

    ContractEntity findContractById(Integer id);
    List<ContractEntity> findAll();
    ContractEntity save(ContractEntity contractEntity);
    void delete(ContractEntity contractEntity);
    void deleteById(Integer id);
   // void updateContractById(Integer id, ContractEntity contractEntity);
}
