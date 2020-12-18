package api.project.UserAPI;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin
public class UtilisateurController {

    @Autowired
    private UtilisateurService service;

    @PostMapping("/addUser")
    public Map<String, String> addUser(@RequestBody Utilisateur user) {
        System.out.println("======================" + user.getEmail());
        UUID uuid = UUID.randomUUID();
        user.setToken(uuid.toString());
        service.saveUser(user);

        HashMap<String, String> map = new HashMap<>();

        map.put("token", user.getToken());
        map.put("id", user.id + "");

        return map;
    }

    @GetMapping("/users")
    public List<Utilisateur> findAllUsers() {
        return service.getUsers();
    }

    @GetMapping("/user/{id}")
    public Utilisateur finUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    // @GetMapping("/user/{name}")
    // public Utilisateur finUserByName(@PathVariable String name) {
    // return service.getUserByName(name);
    // }

    @PutMapping("/update")
    public Utilisateur updateUser(@RequestBody Utilisateur user) {
        return service.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }

}
