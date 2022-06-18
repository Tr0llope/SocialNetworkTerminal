package socialNetwork.business;

import java.util.Scanner;
/**
 * 
 */
public class Experiment {
    protected String description;

    public Experiment(String description){
        this.description=description;
    }
    /**
     * Get the experiment oh the user
     * @return the experiment of the user 
     * @author DARDE Alban
     */
    public static Experiment createExperiment(Scanner scan){
        System.out.print("Experiment:  "); String description = scan.nextLine();
        Experiment experiment = new Experiment(description);
        return experiment;
    }
    /**
     * Method that display the experiment description of the user 
     */
    public void displayExperiment(){
        System.out.println(this.description);
    }
}
