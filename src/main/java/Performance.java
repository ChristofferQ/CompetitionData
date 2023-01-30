import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Performance {
    private int performanceId;
    private int athleteId;
    private int boulderId;
    private int top;
    private int zone;
    private int attemptTop;
    private int attemptZone;
    private LocalTime startTime;
    private LocalTime endTime;

    public Performance() {
    }

    public Performance(int performanceId, int athleteId, int boulderId, int top, int zone, int attemptTop, int attemptZone, LocalTime startTime) {
        this.performanceId = performanceId;
        this.athleteId = athleteId;
        this.boulderId = boulderId;
        this.top = top;
        this.zone = zone;
        this.attemptTop = attemptTop;
        this.attemptZone = attemptZone;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getPerformanceId() {
        return performanceId;
    }

    public int getAthleteId() {
        return athleteId;
    }

    public int getBoulderId() {
        return boulderId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    @Override
    public String toString() {
        return
                " " + performanceId +
                ", " + athleteId +
                ", " + boulderId +
                ", " + top +
                ", " + zone +
                ", " + attemptTop +
                ", " + attemptZone +
                ", " + startTime +
                ", " + endTime
                ;
    }

    public LocalTime randomTime (int start, int end){
        Random random = new Random();
        int randomTime = random.nextInt(start end);
        return

    }

    public LocalTime randomStartTime (LocalTime start, LocalTime end) {
        LocalTime time1 = LocalTime.of(0,0,0);
        LocalTime time2 = LocalTime.of(6,0,0);
        int secondOfDayTime1 = time1.toSecondOfDay();
        int secondOfDayTime2 = time2.toSecondOfDay();
        Random random = new Random();
        int randomSecondOfDay = secondOfDayTime1 + random.nextInt(secondOfDayTime2-secondOfDayTime1);
        start = LocalTime.ofSecondOfDay(randomSecondOfDay);
        end = LocalTime.ofSecondOfDay(randomSecondOfDay + LocalTime.of(0, random.nextInt(6 - 2 + 1) + 2,0).toSecondOfDay());
        return randomLocalStartTime;
    }

    public boolean isBetweenStartAndEnd(List<Performance> checkList, LocalTime startTime, int boulderId) {
        if (checkList.size() != 0) {
            for (Performance performance : checkList) {
                if (performance.getBoulderId() == boulderId) {
                    if (performance.getStartTime().toSecondOfDay() < startTime.toSecondOfDay()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public LocalTime startTimeBasedOnInBetween(List<Performance> checkList, int boulderId) {
        LocalTime startTime = randomStartTime();
        boolean isBetween = isBetweenStartAndEnd(checkList, startTime, boulderId);
        if (isBetween) {
            return randomStartTime();
        } else {
            return startTime;
        }


    }

    public void createPerformance(List<Boulder> boulders, List<Athlete> athletes, List<Performance> performances) {
        //Creating performances
        int i = 0;
        for (Boulder boulder: boulders) {
            for (Athlete athlete: athletes) {
                LocalTime randomLocalStartTime = startTimeBasedOnInBetween(performances, boulder.getBoulderId());

                Performance createdPerformance = athlete.createPerformance(i,athlete.getAthleteId(),boulder.getBoulderId(), randomLocalStartTime);
                performances.add(createdPerformance);
                i++;
            }
        }
    }
}
