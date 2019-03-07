/**
 * Artificial Intelligence, CSCI 580
 * Spring 2019
 *
 * EDIT this file heavily
 *
 * @author <YOUR NAME HERE>
 */
package geneticcode;

import java.util.ArrayList;
import java.util.Random;

/**
 * Static collection of Generic Operators and their helper functions.
 */
public class Operator {
    // Random seed 
    private static final Random r = new Random();

    /**
     * You can access any public static function, such as Main.gMAX *
     * Factory.getRandomKeyword() etc.
     */
    
    // Dummy constructor to prevent object instances
    private Operator() {
    }

    /**
     * Pick two Programs at random and select the one with the higher score
     * @param population the population to select from
     * @return the superior Program
     */
    public static Program tournamentSelection(ArrayList<Program> population){
        int i = r.nextInt(population.size());
        int j = r.nextInt(population.size());
        return population.get(i).getScore() > population.get(j).getScore() ? population.get(i) : population.get(j);
    }
    
    
    /**
     * Select the next generation of Programs
     *
     * @param prevGeneration a population from which to select
     * @param generation the generation number
     * @return the selected population
     */
    public static ArrayList<Program> selection(ArrayList<Program> prevGeneration, int generation) {
        // Copy from one generation to the next
        ArrayList<Program> nextGeneration = new ArrayList<Program>();

        for (int i = 0; i < prevGeneration.size(); i++) {
            nextGeneration.add(tournamentSelection(prevGeneration));
        }

        return nextGeneration;
    }

    /**
     * Perform crossover across an initial population
     *
     * @param population the initial population to draw from
     * @param generation the generation number
     * @return a new population of children
     */
    public static ArrayList<Program> crossover(ArrayList<Program> population, int generation) {
        ArrayList<Program> children = new ArrayList<>();

        /**
         * This crossover attempts to mate all (with itself). 
         * Write a better crossover operator.
         */
        for (Program program : population) {
            // Should you crossover all?
            Program child = crossover(program, program);
            children.add(child);
        }
        return children;
    }

    /**
     * Perform the crossover between two parents
     *
     * @param program1 the first parent
     * @param program2 the second parent
     * @return a new Program recombined from the two parents
     */
    public static Program crossover(Program program1, Program program2) {
        /**
         * This does not perform crossover. Write a better crossover operator.
         */

        // Naively, the child is just the first parent.  Do better.
        Program childProgram = program1;

        return childProgram;
    }

    /**
     * Mutate the population (or just a subset)
     *
     * @param population the initial population to draw from
     * @param generation the generation number
     * @return a new population of mutants, possibly zombies
     */
    public static ArrayList<Program> mutate(ArrayList<Program> population, int generation) {
        ArrayList<Program> mutants = new ArrayList<>();

        for (Program program : population) {

            Program mutant = program; 

            // Mutate 3 of every 10 programs
            if ((new Random()).nextInt(10) < 3) {
                mutant = mutate(program);
            }

            mutants.add(mutant);
        }

        return mutants;
    }

    /**
     * Mutate an individual program
     *
     * @param program the program to mutate
     * @return the mutated Program
     */
    public static Program mutate(Program program) {

        program.addRandomStatements((new Random()).nextInt(20)); 
        // program.removeRandomStatement();

        // duplicate statement in 20% of programs
        if ((new Random()).nextInt(5) < 2)
            program.duplicateRandomStatement(); 

        return program;
    }

    /**
     * ******************************
     * NEED MORE METHODS?
     *
     * Add your static methods below.
     *
     ******************************
     */
}
