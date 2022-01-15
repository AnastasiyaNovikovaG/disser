package novikava.controller;

import novikava.entity.Converter;
import novikava.entity.LogbookEntity;
import novikava.entity.LogbookModel;
import novikava.service.LogbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/logbook")
public class LogbookController {


    @Autowired
    public LogbookService logbookService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<LogbookModel> getAllLogbooks() {

        List<LogbookEntity> logbookEntities = logbookService.findAll();
        List<LogbookModel> logbookModels = logbookEntities.stream().map(Converter::convert).collect(Collectors.toList());
return logbookModels;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<LogbookEntity> getLogbookById(@PathVariable(name = "id") Integer id) {
        LogbookEntity logbookEntity = logbookService.findLogbookById(id);
        return ResponseEntity.ok(logbookEntity);
    }

    @RequestMapping(value = "/month/{monthId}", method = RequestMethod.GET)
    public List<LogbookEntity> getLogbookByMonth(@PathVariable(name = "monthId") Integer id) {
        //LogbookEntity logbookEntity = logbookService.findLogbookEntityByTeacherByIdTeach(id);
        //LogbookEntity logbookEntity = logbookService.findLogbookEntityByIdTeach(id);
        return logbookService.findAllByMonthsId(id);
    }

    @RequestMapping(value = "/my/{teacherId}", method = RequestMethod.GET)
    public List<LogbookEntity> getLogbookByTeacherId(@PathVariable(name = "teacherId") Integer id) {
        //LogbookEntity logbookEntity = logbookService.findLogbookEntityByTeacherByIdTeach(id);
        //LogbookEntity logbookEntity = logbookService.findLogbookEntityByIdTeach(id);
        return logbookService.findAllByIdTeach(id);
    }

    @RequestMapping(value = "/my/{teacherId}/{monthId}", method = RequestMethod.GET)
    public List<LogbookEntity> getLogbookByTeacherIdAndIdMonth(@PathVariable(name = "teacherId") Integer teacher,
                                                               @PathVariable(name = "monthId") Integer month) {
        //LogbookEntity logbookEntity = logbookService.findLogbookEntityByTeacherByIdTeach(id);
        //LogbookEntity logbookEntity = logbookService.findLogbookEntityByIdTeach(id);
        return logbookService.findAllByMonthsIdAndIdTeach(month,teacher);
    }

    @RequestMapping(value = "/department/{departmentId}/{monthId}", method = RequestMethod.GET)
    public List<LogbookEntity> getLogbooksByMonthAndDepartment(@PathVariable(name = "departmentId") Integer department,
                                                                         @PathVariable(name = "monthId") Integer month) {
        //LogbookEntity logbookEntity = logbookService.findLogbookEntityByTeacherByIdTeach(id);
        return logbookService.findAllByMonthsIdAndDepartmentId(month, department);
    }

    @RequestMapping(method = RequestMethod.POST)
    public LogbookEntity saveLogbook(@RequestBody LogbookEntity logbookEntity){
        return logbookService.save(logbookEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public LogbookEntity updateLogbook(@PathVariable("id") Integer id,
                                         @RequestBody LogbookEntity logbook) {
        LogbookEntity logbookData = logbookService.findLogbookById(id);
        logbookData.setHours(logbook.getHours());
        return logbookService.save(logbookData);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteLogbookById(@PathVariable("id") Integer id) {
        try {
            logbookService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}
