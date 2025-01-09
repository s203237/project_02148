package service;

import org.jspace.SequentialSpace;
import org.jspace.Space;

public class SpaceService {
    private Space space;
    public SpaceService(){
        space =new SequentialSpace();
    }
    public Space getSpace() {
        return space;
    }
}
