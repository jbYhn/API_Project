package api.project.Api_Project;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
