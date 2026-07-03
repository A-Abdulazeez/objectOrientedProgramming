package problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonalsTest {

    @Test
    void testProblemCanBeCreated() {

        Problems problem = new Problems("School Fees", ProblemTypes.FINANCIAL);

        assertEquals("School Fees", problem.getName());
        assertEquals(ProblemTypes.FINANCIAL, problem.getType());
        assertFalse(problem.isSolved());
    }

    @Test
    void testPersonCanAddProblem() {

        Personals person = new Personals("John");
        Problems problem = new Problems("School Fees", ProblemTypes.FINANCIAL);

        person.addProblem(problem);

        assertEquals(1, person.getProblems().size());
    }

    @Test
    void testPersonCanSolveProblem() {

        Personals person = new Personals("John");

        Problems problem = new Problems("School Fees", ProblemTypes.FINANCIAL);

        person.addProblem(problem);

        person.solveProblem("School Fees");

        assertTrue(problem.isSolved());
    }

    @Test
    void testRecountProblemsReturnsOnlyUnsolvedProblems() {

        Personals person = new Personals("John");

        Problems problem1 = new Problems("School Fees", ProblemTypes.FINANCIAL);
        Problems problem2 = new Problems("Learn Java", ProblemTypes.EDUCATION);

        person.addProblem(problem1);
        person.addProblem(problem2);

        person.solveProblem("Learn Java");

        List<Problems> unsolvedProblems = person.recountProblems();

        assertEquals(1, unsolvedProblems.size());
        assertEquals("School Fees", unsolvedProblems.get(0).getName());
    }

    @Test
    void testSolveProblemThatDoesNotExist() {

        Personals person = new Personals("John");

        person.solveProblem("Unknown Problem");

        assertTrue(person.getProblems().isEmpty());
    }
}
