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
        for (Boulder boulder: boulders) {
            for (Athlete athlete: athletes) {
                LocalTime time1 = LocalTime.of(0,0,0);
                LocalTime time2 = LocalTime.of(6,0,0);
                int secondOfDayTime1 = time1.toSecondOfDay();
                int secondOfDayTime2 = time2.toSecondOfDay();
                Random random = new Random();
                int randomSecondOfDay = secondOfDayTime1 + random.nextInt(secondOfDayTime2-secondOfDayTime1);
                LocalTime randomLocalStartTime = LocalTime.ofSecondOfDay(randomSecondOfDay);
                LocalTime randomLocalEndTime = LocalTime.ofSecondOfDay(randomSecondOfDay + LocalTime.of(0, random.nextInt(6 - 2 + 1) + 2,0).toSecondOfDay());
                Performance createdPerformance = athlete.createPerformance(i,athlete.getAthleteId(),boulder.getBoulderId(), randomLocalStartTime, randomLocalEndTime);
                performances.add(createdPerformance);
                i++;
            }
        }
        //Sorting by endTime ascending
        Comparator<Performance> comparatorPerformance = (prod1, prod2) -> prod1.getEndTime().compareTo(prod2.getEndTime());
        Collections.sort(performances, comparatorPerformance);
        //performances.forEach(prod -> System.out.println(prod));

        File csvFile = new File("CompetitionData.csv");
        String[] entries = {"performanceId", "athleteId", "boulderId", "T", "Z", "aT", "aZ", "startTime", "endTime"};
        FileWriter fileWriter = new FileWriter(csvFile);
        for (String str: entries
             ) fileWriter.write((str) + ", "); {

        }
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

        /* Work in progress
        //System.out.println(performances);
        for (Performance performance: performances) {
            LocalTime startTime = performance.getStartTime();
            LocalTime endTime = performance.getEndTime();
            System.out.println(performance.getBoulderId());
        }
        */
    }
}
