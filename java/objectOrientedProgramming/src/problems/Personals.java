package problems;

import java.util.ArrayList;
import java.util.List;

public class Personals {

    private String name;
    private List<Problems> problems;

    public Personals(String name) {
        this.name = name;
        this.problems = new ArrayList<>();
    }

    public void addProblem(Problems problem) {
        problems.add(problem);
    }

    public void solveProblem(String problemName) {
        for (Problems problem : problems) {
            if (problem.getName().equalsIgnoreCase(problemName)) {
                problem.solve();
                break;
            }
        }
    }

    public List<Problems> recountProblems() {

        List<Problems> unsolvedProblems = new ArrayList<>();

        for (Problems problem : problems) {
            if (!problem.isSolved()) {
                unsolvedProblems.add(problem);
            }
        }

        return unsolvedProblems;
    }

    public List<Problems> getProblems() {
        return problems;
    }
}