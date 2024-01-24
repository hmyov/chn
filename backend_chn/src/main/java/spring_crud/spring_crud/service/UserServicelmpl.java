package backend_chn.backend_chn.service;
import backend_chn.backend_chn.entity.UserProfile;
import backend_chn.backend_chn.repository.UserRepository;
// Importing required classes
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Annotation
@Service
// Class implementing DepartmentService class
public class UserServicelmpl
        implements UserService {

    @Autowired
    private UserRepository userRepository;

    // Save operation
    @Override
    public UserProfile saveUser(UserProfile user)
    {
        return userRepository.save(user);
    }

    // Read operation
    @Override public List<UserProfile> fetchUserList()
    {
        return (List<UserProfile>)
                userRepository.findAll();
    }

    // Update operation
    @Override
    public UserProfile
    updateUser(UserProfile user,
                     Long departmentId)
    {

       UserProfile depDB
                = userRepository.findById(departmentId)
                .get();

        if (Objects.nonNull(user.getUser_firstname())
                && !"".equalsIgnoreCase(
                user.getUser_firstname())) {
            depDB.setUser_firstname(
                  user.getUser_firstname());
        }

        if (Objects.nonNull(
                user.getUser_lastname())
                && !"".equalsIgnoreCase(
                user.getUser_lastname())) {
            depDB.setUser_lastname(
                    user.getUser_lastname());
        }

        if (Objects.nonNull(user.getUsername())
                && !"".equalsIgnoreCase(
                user.getUsername())) {
            depDB.setUsername(
                    user.getUsername());
        }

        return userRepository.save(depDB);
    }

    // Delete operation
    @Override
    public void deleteUserById(Long userId)
    {
        userRepository.deleteById(userId);
    }
}
