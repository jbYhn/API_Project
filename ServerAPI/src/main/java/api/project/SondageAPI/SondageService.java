package api.project.SondageAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SondageService {
    @Autowired
    private SondageRepository sondageRepository;

    public Sondage saveSondage(Sondage survey) {
        return sondageRepository.save(survey);
    }

    public List<Sondage> getSondages() {
        return sondageRepository.findAll();
    }

    public Sondage getSondageById(int id) {
        return sondageRepository.findById(id).orElse(null);
    }

    public Sondage getSondageByName(String name) {
        return sondageRepository.findSondageByDescription(name);
    }

    public String deleteSondage(int id) {
        sondageRepository.deleteById(id);
        return "Sondage removed !! " + id;
    }

    public Sondage updateSondage(Sondage survey) {
        Sondage theSurvey = sondageRepository.findById(survey.getId()).orElse(null);
        theSurvey.setDescription(survey.getDescription());
        theSurvey.setLieu(survey.getLieu());
        theSurvey.setId(survey.getId());
        theSurvey.setUser_id(survey.getUser_id());
        return sondageRepository.save(theSurvey);
    }
}
