
// Importing packages
package backend_chn.backend_chn.service;
import backend_chn.backend_chn.entity.UserProfile;
// Importing required classes
import java.util.List;

// Class
public interface UserService {

    // Save operation
    UserProfile saveUser(UserProfile user);

    // Read operation
    List<UserProfile> fetchUserList();

    // Update operation
    UserProfile updateUser(UserProfile user,Long userId);

    // Delete operation
    void deleteUserById(Long userId);
}
