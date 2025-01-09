package service;

import model.User;
import org.jspace.ActualField;
import org.jspace.FormalField;
import org.jspace.Space;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private Space space;
    public UserService(Space space){
        this.space = space;
    }
    //add new user

    public void addUser(User user) throws InterruptedException {
        space.put(user.getName(), user.getEmail(), user.getPassword());
    }

    // user authentication
    public User authenticate(String email, String password) throws InterruptedException {
        Object[] tuple = space.query(new ActualField(email), new ActualField(password), new FormalField(String.class));
        if (tuple != null) {
            return new User((String) tuple[0], (String) tuple[1], (String) tuple[2]);
        }
        return null;
    }
    // Get user information
    public User getUser(String email) throws InterruptedException {
        Object[] tuple = space.query(new ActualField(email), new FormalField(String.class), new FormalField(String.class));
        if (tuple != null) {
            return new User((String) tuple[0], (String) tuple[1], (String) tuple[2]);
        }
        return null;
    }

    // update user information
    public void updateUser(String email, User updatedUser) throws InterruptedException {
        space.get(new ActualField(email), new FormalField(String.class), new FormalField(String.class));
        space.put(updatedUser.getName(), updatedUser.getEmail(), updatedUser.getPassword());
    }

    // delete user
    public void deleteUser(String email) throws InterruptedException {
        space.get(new ActualField(email), new FormalField(String.class), new FormalField(String.class));
    }
}