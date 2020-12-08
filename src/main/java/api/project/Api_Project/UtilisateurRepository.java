package api.project.Api_Project;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

//        List<Utilisateur> findByLastName(String lastName);
//
//        Utilisateur findById(long id);

}
