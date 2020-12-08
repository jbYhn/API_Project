package api.project.Api_Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")


public class UtilisateurController {

    @Autowired
    private UtilisateurRepository uRepo;

    /**
     * Get all Users list
     * @return the list
     */
    @GetMapping("/Utilisateur")
    public List<Utilisateur> getAllUsers() {
        return uRepo.findAll();
    }

    /**
     * Get a user by his id
     * @param userId
     * @return the users by id
     * @throws ResourceNotFoundException
     */
    @GetMapping("/Utilisateur/{id}")
    public ResponseEntity<Utilisateur> getUserById(@PathVariable(value = "id") Long userId)
        throws ResourceNotFoundException {
        Utilisateur user = uRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
        return ResponseEntity.ok().body(user);
    }

    /**
     * Create Utilisateur user
     * @param user
     * @return the created user
     */
    @PostMapping("/Utilisateur")
    public Utilisateur createUser(@Validated @RequestBody Utilisateur user) {
        return uRepo.save(user);
    }

    /**
     * Update user response entity
     * @param userId
     * @param userDetails
     * @return the response entity
     * @throws ResourceNotFoundException
     */
    @PutMapping("/Utilisateur/{id}")
    public ResponseEntity<Utilisateur> updateUser(@PathVariable(value = "id") Long userId, @Validated @RequestBody Utilisateur userDetails)
        throws ResourceNotFoundException {
        Utilisateur user = uRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
        user.setEmail(userDetails.getEmail());
        user.setLogin(userDetails.getLogin());
        user.setName(userDetails.getName());
        user.setId(userDetails.getId());
        final Utilisateur updatedUser = uRepo.save(user);

        return ResponseEntity.ok(updatedUser);
    }

    /**
     * Delete user map
     * @param userId
     * @return the user deleted map
     * @throws Exception
     */
    @DeleteMapping("/Utilisateur/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception
    {
        Utilisateur user = uRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
        uRepo.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }


}
