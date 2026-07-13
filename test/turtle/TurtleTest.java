package turtle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TurtleTest {

    @Test
    public void turtlePositionStartingPointIsAtZeroTest(){
        Turtle turtle = new Turtle();
        assertTrue(turtle.isPenUp());
    }

}