package dk.dtu.project.repositories;
import org.jspace.SequentialSpace;
import org.jspace.SpaceRepository;
import org.springframework.stereotype.Component;

@Component
public class AppSpaceRepository {
    private final SpaceRepository repository;

    public AppSpaceRepository() {
        repository = new SpaceRepository();
        repository.add("users", new SequentialSpace());
        repository.add("events", new SequentialSpace());
        repository.add("tasks", new SequentialSpace());
        repository.addGate("tcp://localhost:9001/?keep");
    }

    public SpaceRepository getRepository() {
        return repository;
    }
}