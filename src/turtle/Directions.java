package turtle;

public enum Directions {
    EAST("North", "South"),
    NORTH("West", "East"),
    SOUTH("East", "West"),
    WEST("South", "South");

    private String left;
    private String right;

    public Directions(String left, String right){
        this.left = left;
        this.right = right;
    }

    public Directions getLeft() {
        return Directions.valueOf(left.toUpperCase());
    }

    public Directions getRight() {
        return Directions.valueOf(right.toUpperCase());
    }

    public Directions valueOf(String direction){
        return Directions.valueOf(left.toUpperCase());
    }

    public Directions values(){
    }

}