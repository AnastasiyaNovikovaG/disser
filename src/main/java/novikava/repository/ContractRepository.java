package novikava.repository;

import novikava.entity.ContractEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends CrudRepository<ContractEntity, Integer> {

    ContractEntity findContractById(Integer id);
    List<ContractEntity> findAll();
    ContractEntity save(ContractEntity contractEntity);
    void delete(ContractEntity contractEntity);
    void deleteById(Integer id);
    //void updateContractById(Integer id, ContractEntity contractEntity);

}
