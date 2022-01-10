package novikava.controller;

import novikava.entity.AcademicDegreeEntity;
import novikava.entity.TypeOfClassEntity;
import novikava.service.AcademicDegreeService;
import novikava.service.TypeOfClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/type")
public class TypeOfClassController {

    @Autowired
    public TypeOfClassService typeOfClassService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<TypeOfClassEntity> getAllTypes() {
        return typeOfClassService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TypeOfClassEntity> getTypeById(@PathVariable(name = "id") Integer id) {
        TypeOfClassEntity typeOfClassEntity = typeOfClassService.findTypeOfClassById(id);
        return ResponseEntity.ok(typeOfClassEntity);
    }
}
