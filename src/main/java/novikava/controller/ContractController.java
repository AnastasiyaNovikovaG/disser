package novikava.controller;


import novikava.entity.ContractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import novikava.service.ContractService;

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

}
