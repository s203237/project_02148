package dk.dtu.project.config;
import org.jspace.Space;
import org.jspace.SequentialSpace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpaceConfig {
    @Bean
    public Space space() {
        return new SequentialSpace();
    }
}
