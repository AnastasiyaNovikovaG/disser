package novikava.controller;


import novikava.entity.ContractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import novikava.service.ContractService;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    public ContractService contractService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<ContractEntity> getAllContracts() {
        return contractService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ContractEntity> getContractById(@PathVariable(name = "id") Integer id) {
        ContractEntity contractEntity = contractService.findContractById(id);
        return ResponseEntity.ok(contractEntity);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ContractEntity saveContract(@RequestBody ContractEntity contractEntity){
        return contractService.save(contractEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ContractEntity updateContract(@PathVariable("id") Integer id,
                                         @RequestBody ContractEntity contract) {
       ContractEntity contractData = contractService.findContractById(id);
       contractData.setContractNo(contract.getContractNo());
       return contractService.save(contractData);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteContractById(@PathVariable("id") Integer id) {
        try {
            contractService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}
