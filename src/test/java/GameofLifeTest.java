import javafx.scene.Group;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameofLifeTest {

    @Test
    public void addrectangle() {
        new GameofLife().addrectangle(new Group());
    }
}