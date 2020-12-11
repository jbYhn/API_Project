package api.project.UserAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository repository;

    public Utilisateur saveUser(Utilisateur user) {
        return repository.save(user);
    }

    public List<Utilisateur> saveUsers(List<Utilisateur> users) {
        return repository.saveAll(users);
    }

    public List<Utilisateur> getUsers() {
        return repository.findAll();
    }

    public Utilisateur getUserById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Utilisateur getUserByName(String name) {
        return repository.findByName(name);
    }

    public String deleteUser(int id) {
        repository.deleteById(id);
        return "user removed !! " + id;
    }



    public Utilisateur updateUser(Utilisateur user) {
        Utilisateur theUser = repository.findById(user.getId()).orElse(null);
        theUser.setName(user.getName());
        theUser.setPassword(user.getPassword());
        theUser.setEmail(user.getEmail());
        return repository.save(theUser);
    }

}
