package backend_chn.backend_chn.controller;

import backend_chn.backend_chn.entity.UserProfile;
import backend_chn.backend_chn.service.UserService;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


// Annotation
@RestController
// Class
public class UserController {

    @Autowired private UserService userService;

    // Save operation
    @PostMapping("/users")

    public UserProfile saveUser(
            @Valid @RequestBody UserProfile user)
    {
        return userService.saveUser(user);
    }

    // Read operation
    @GetMapping("/users")

    public List<UserProfile> fetchUserList()
    {
        return userService.fetchUserList();
    }

    // Update operation
    @PutMapping("/users/{id}")

    public UserProfile
    updateUser(@RequestBody UserProfile user,
                     @PathVariable("id") Long userId)
    {
        return userService.updateUser(
                user, userId);
    }

    // Delete operation
    @DeleteMapping("/users/{id}")

    public String deleteUserById(@PathVariable("id")
                                       Long userId)
    {
        userService.deleteUserById(
                userId);
        return "Deleted Successfully";
    }
}
