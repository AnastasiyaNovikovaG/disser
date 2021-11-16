package novikava.controller;


import novikava.entity.DepartmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import novikava.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    public DepartmentService departmentService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<DepartmentEntity> getAllDepartments() {
        return departmentService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<DepartmentEntity> getDepartmentById(@PathVariable(name = "id") Integer id) {
        DepartmentEntity departmentEntity = departmentService.findDepartmentById(id);
        return ResponseEntity.ok(departmentEntity);
    }

}
