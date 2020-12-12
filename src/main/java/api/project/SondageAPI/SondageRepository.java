package api.project.SondageAPI;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SondageRepository extends JpaRepository<Sondage, Integer> {
    // Sondage findSondageByDescription(int id);
}
