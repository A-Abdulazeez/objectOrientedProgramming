package turtle;

public class TurtlePosition {

    private int row;
    private int colomn;

    public TurtlePosition(int row, int colomn) {
        this.row = row;
        this.colomn = colomn;
    }

    public int getRowPosition() {
        return row;
    }

    public int getColomnPosition() {
        return colomn;
    }

    public void increaseColomnPosition(int amount) {
        colomn = colomn + amount;
    }

}
