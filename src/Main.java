import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Athlete> athletes = new ArrayList();
        List<Boulder> boulders = new ArrayList();
        List<Performance> performances = new ArrayList<>();

        //Creating athletes
        for (int i = 0; i < 81; i++) {
            Athlete athlete = new Athlete(i);
            athletes.add(athlete);
        }

        //Creating boulders
        for (int i = 0; i < 19; i++) {
            Boulder boulder = new Boulder(i);
            boulders.add(boulder);
        }

        //Creating performances
        int i = 0;
        for (Athlete athlete: athletes) {
            for (Boulder boulder: boulders) {
               Performance createdPerformance = athlete.createPerformance(i,boulder.getBoulderId(),athlete.getAtheleteId());
               performances.add(createdPerformance);
               i++;
            }
        }
        System.out.println(performances);
    }
}
