package api.project.SondageAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SondageController {
    @Autowired
    public SondageService service;

    @PostMapping("/addSurvey")
    public Sondage addSondage(@RequestBody Sondage survey) {
        return service.saveSondage(survey);
    }


    @GetMapping("/surveys")
    public List<Sondage> findAllSurvey() {
        return service.getSondages();
    }

    @GetMapping("/survey/{id}")
    public Sondage finSurveyById(@PathVariable int id) {
        return service.getSondageById(id);
    }

//    @GetMapping("/user/{name}")
//    public Utilisateur finUserByName(@PathVariable String name) {
//        return service.getUserByName(name);
//    }

    @PutMapping("/updateSurvey")
    public Sondage updateSurvey(@RequestBody Sondage survey) {
        return service.updateSondage(survey);
    }

    @DeleteMapping("/deleteSurvey/{id}")
    public String deleteSurvey(@PathVariable int id) {
        return service.deleteSondage(id);
    }
}
