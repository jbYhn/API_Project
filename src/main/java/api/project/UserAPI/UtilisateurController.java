package api.project.UserAPI;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UtilisateurController {

    @Autowired
    private UtilisateurService service;

    @PostMapping("/addUser")
    public Utilisateur addUser(@RequestBody Utilisateur user) {
        return service.saveUser(user);
    }


    @GetMapping("/users")
    public List<Utilisateur> findAllUsers() {
        return service.getUsers();
    }

    @GetMapping("/user/{id}")
    public Utilisateur finUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

//    @GetMapping("/user/{name}")
//    public Utilisateur finUserByName(@PathVariable String name) {
//        return service.getUserByName(name);
//    }

    @PutMapping("/update")
    public Utilisateur updateUser(@RequestBody Utilisateur user) {
        return service.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }



}
