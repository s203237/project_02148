package service;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();
    //add new user
    public void addUser (User user){
        users.add(user);
    }
    //identify user
    public User authenticate(String email, String password){
        for(User user:users){
            if (user.getEmail().equals(email)&& user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
    public List<User> getUsers(){
        return users;
    }
}
