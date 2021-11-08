package novikava.service.impl;

import novikava.entity.ContractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import novikava.repository.ContractRepository;
import novikava.service.ContractService;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public ContractEntity findContractById(Integer id) {
        return contractRepository.findContractById(id);
    }

    @Override
    public List<ContractEntity> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public ContractEntity save(ContractEntity contractEntity) {
        return contractRepository.save(contractEntity);
    }

    @Override
    public void delete(ContractEntity contractEntity) {
        contractRepository.delete(contractEntity);
    }

    @Override
    public void deleteById(Integer id) {
        contractRepository.deleteById(id);
    }

    @Override
    public void updateContractById(Integer id, ContractEntity contractEntity) {
        contractRepository.updateContractById(id,contractEntity);
    }
}
