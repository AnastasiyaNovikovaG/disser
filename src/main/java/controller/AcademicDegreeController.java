package controller;

import entity.AcademicDegree;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.AcademicDegreeRepository;

import java.util.List;

@RestController
@RequestMapping("/academicdegree")
public class AcademicDegreeController {

    @Override
    public AcademicDegree findAcademicDegreeById(Integer integer) {
        return null;
    }

    @Override
    public List<AcademicDegree> findAll() {
        return null;
    }
}
