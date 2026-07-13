package problems;

public class Problems {

    private String name;
    private ProblemTypes type;
    private boolean solved;

    public Problems(String name, ProblemTypes type) {
        this.name = name;
        this.type = type;
        this.solved = false;
    }

    public String getName() {
        return name;
    }

    public ProblemTypes getType() {
        return type;
    }

    public boolean isSolved() {
        return solved;
    }

    public void solve() {
        solved = true;
    }
}