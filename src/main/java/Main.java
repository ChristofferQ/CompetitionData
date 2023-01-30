import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Athlete> athletes = new ArrayList();
        List<Boulder> boulders = new ArrayList();
        List<Performance> performances = new ArrayList<>();
        Performance performanceCreator = new Performance();

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
        performanceCreator.createPerformance(boulders, athletes, performances);

        //Sorting by endTime ascending
        Comparator<Performance> comparatorPerformance = (prod1, prod2) -> prod1.getEndTime().compareTo(prod2.getEndTime());
        Collections.sort(performances, comparatorPerformance);
        //performances.forEach(prod -> System.out.println(prod));

        //Writing data to file
        File csvFile = new File("CompetitionData.csv");
        String[] entries = {"performanceId", "athleteId", "boulderId", "T", "Z", "aT", "aZ", "startTime", "endTime"};
        FileWriter fileWriter = new FileWriter(csvFile);
        StringJoiner j = new StringJoiner(", ").setEmptyValue("nothing");
        for (String str : entries) {
            j.add(str);
        }
        fileWriter.write(String.valueOf(j));
        fileWriter.write("\n");
        for (Performance performance : performances) {
            try {
                fileWriter.write(performance.toString());
                fileWriter.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        fileWriter.close();

        //System.out.println(performances);

        //Make sure time doesn't overlap on the same boulder
        //TODO: Finish and add it to createPerformance in athlete
        for (Performance performance1: performances) {
            for (Performance performance2: performances) {
                if (performance1 == performance2) {
                    continue;
                }
                LocalTime startTime1 = performance1.getStartTime();
                LocalTime endTime1 = performance1.getEndTime();

                LocalTime startTime2 = performance2.getStartTime();
                LocalTime endTime2 = performance2.getEndTime();

                int boulderId1 = performance1.getBoulderId();
                int boulderId2 = performance2.getBoulderId();

                if (boulderId1 == boulderId2) {
                    System.out.println("Performance: " + performance1.getPerformanceId() + "\n" + "Same id: " + "\n" + boulderId1 + ": " + startTime1 + "\n" + boulderId1 + ": "  + startTime2);
                }
            }
        }
    }
}
