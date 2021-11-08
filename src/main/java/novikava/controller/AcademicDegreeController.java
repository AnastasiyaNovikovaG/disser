package novikava.controller;

import novikava.entity.AcademicDegreeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import novikava.service.AcademicDegreeService;

import java.util.List;

@RestController
@RequestMapping("/academicdegree")
public class AcademicDegreeController {

    @Autowired
    public AcademicDegreeService academicDegreeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<AcademicDegreeEntity> getAllDegrees() {
        return academicDegreeService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AcademicDegreeEntity> getAcademicDegreeById(@PathVariable(name = "id") Integer id) {
        AcademicDegreeEntity academicDegreeEntity = academicDegreeService.findAcademicDegreeById(id);
        return ResponseEntity.ok(academicDegreeEntity);
    }

}
