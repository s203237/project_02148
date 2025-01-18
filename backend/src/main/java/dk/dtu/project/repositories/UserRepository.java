package dk.dtu.project.repositories;


import org.jspace.ActualField;
import org.jspace.FormalField;
import org.jspace.Space;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final Space space;

    public UserRepository(AppSpaceRepository appSpaceRepository) {
        this.space = appSpaceRepository.getRepository().get("users");
    }

    // Add/ register new users to Space
    public void addUser(String email, String name, String password) throws InterruptedException {
        space.put(email, name, password);
    }

    // Query user by email
    public Object[] getUserByEmail(String email) throws InterruptedException {
        return space.query(new ActualField(email), new FormalField(String.class), new FormalField(String.class));
    }

    // Delete user by email
    public void deleteUserByEmail(String email) throws InterruptedException {
        space.get(new ActualField(email), new FormalField(String.class), new FormalField(String.class));
    }
}