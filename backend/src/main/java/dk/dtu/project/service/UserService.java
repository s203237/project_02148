package dk.dtu.project.service;

import dk.dtu.project.model.User;
import org.jspace.ActualField;
import org.jspace.FormalField;
import org.jspace.Space;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final Space space;
    private final BCryptPasswordEncoder passwordEncoder;

    // Constructor
    public UserService(Space space){
        this.space = space;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    //add new user/ create user
    public boolean addUser(User user) throws InterruptedException {
        // check if email already exists
        if (getUser(user.getEmail()) != null) {
            return false;
        }
        //Encrypt password before saving
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        space.put(user.getEmail(),user.getName(), encryptedPassword);
        return true;
    }

    // authentication user
    public User authenticate(String email, String password) throws InterruptedException {
        Object[] tuple = space.query(new ActualField(email), new FormalField(password), new FormalField(String.class));
        if (tuple != null) {
            String storedPassword = (String) tuple[2];
            if (passwordEncoder.matches(password, storedPassword)) {
                return new User(null, (String) tuple[0], (String) tuple[1], storedPassword);
            }
        }
        return null;
    }
    // Get user information
    public User getUser(String email) throws InterruptedException {
        Object[] tuple = space.query(new ActualField(email), new FormalField(String.class), new FormalField(String.class));
        if (tuple != null) {
            return new User(null,(String) tuple[0], (String) tuple[1], (String) tuple[2]);
        }
        return null;
    }

    // update user (profile)
    public boolean updateUser(String email, User updatedUser) throws InterruptedException {
        if(getUser(email)== null){
            return false;
        }
        space.get(new ActualField(email), new FormalField(String.class), new FormalField(String.class));
        String encryptedPassword = passwordEncoder.encode(updatedUser.getPassword());
        space.put(updatedUser.getName(), updatedUser.getEmail(), encryptedPassword);
        return true;
    }

    // delete user
    public void deleteUser(String email) throws InterruptedException {
        if(getUser(email)==null){return false;}
        space.get(new ActualField(email), new FormalField(String.class), new FormalField(String.class));
        return true;
    }
}