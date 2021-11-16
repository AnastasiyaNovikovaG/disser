package novikava.controller;


import novikava.entity.FacultyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import novikava.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    public FacultyService facultyService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<FacultyEntity> getAllFaculties() {
        return facultyService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<FacultyEntity> getFacultyById(@PathVariable(name = "id") Integer id) {
        FacultyEntity facultyEntity = facultyService.findFacultyById(id);
        return ResponseEntity.ok(facultyEntity);
    }

}
