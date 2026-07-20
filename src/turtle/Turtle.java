package turtle;

public class Turtle {
    private boolean penIsUp = true;
    private Directions direction;
    private TurtlePosition position;

    public boolean isPenUp(){
        return penIsUp;
    }

    public void turnRight() {
        direction = direction.getRight();

    }

    public void turnLeft() {
        direction = direction.getLeft();
    }

    public TurtlePosition getPosition() {
        return position;
    }

    public Directions getCurentDirection() {
        return direction;
    }

    public void movePenDown() {
        penIsUp = false;
    }

    public void movePenUp() {
        penIsUp =  true;
    }

    public void moveFoward(int steps) {
        switch (direction) {
            case EAST -> position.increaseColomnPosition(steps);
            case NORTH -> position.increaseColomnPosition(steps);
            case SOUTH -> position.increaseColomnPosition(steps);
            case WEST -> position.increaseColomnPosition(steps);
        }
    }


}
