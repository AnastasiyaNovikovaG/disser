package novikava.controller;


import novikava.entity.AcademicTitleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import novikava.service.AcademicTitleService;

import java.util.List;

@RestController
@RequestMapping("/academictitle")
public class AcademicTitleController {

    @Autowired
    public AcademicTitleService academicTitleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<AcademicTitleEntity> getAllTitles() {
        return academicTitleService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AcademicTitleEntity> getAcademicTitleById(@PathVariable(name = "id") Integer id) {
        AcademicTitleEntity academicTitleEntity = academicTitleService.findAcademicTitleById(id);
        return ResponseEntity.ok(academicTitleEntity);
    }

}
